package assignment3;


import java.lang.reflect.Array;
import java.util.*;

public class Graph {
    ArrayList<ArrayList<Boolean>> AdjMatrix;
    ArrayList<String> Dictionary;
    int numEdges;
    int numNodes;

    public Graph(Set Dictionary){
        numNodes = Dictionary.size();
        AdjMatrix = new ArrayList<ArrayList<Boolean>>();
        createMatrix(Dictionary);
    }

    private void createMatrix(Set Dictionary){
        /*
        This method creates an ADJ matrix which is responsible for keeping track of each edge between nodes
        The matrix is indexed using the position in the set
        if there is an edge between two nodes or words in the dictionary put true in the matrix
        for each word there is an edge between words if they are separated by one letter
         */
        for(int i = 0;i<numNodes;i++){
            AdjMatrix.add(new ArrayList<Boolean>());
            for(int j = 0;j<numNodes;j++){
                AdjMatrix.get(i).add(false);
            }
        }

        this.Dictionary = new ArrayList<>();
        this.Dictionary.addAll(Dictionary);
        for(int i = 0;i<numNodes;i++){
            for(int j=0;j<numNodes;j++){
                boolean hasEdge = (diffByOneLetter(this.Dictionary.get(i),this.Dictionary.get(j)) && i!=j);
                if(hasEdge)
                    AdjMatrix.get(i).set(j,true);
                else
                    AdjMatrix.get(i).set(j,false);
            }
        }
    }

    public static boolean diffByOneLetter(String wordA,String wordB){
        int mistake = 1;
        for(int i = 0;i<wordA.length();i++){
            if(wordA.charAt(i) != wordB.charAt(i))
                mistake--;
            if(mistake<0)
                return false;
        }
        return true;
    }

    public ArrayList<String> DFS(String sourceNode,String endNode){
        Stack<String> stack = new Stack<>();
        Vector<Boolean> visited = new Vector<>(); //size = number of words; a word's corresponding spot is set to true once it's been added to the word ladder
        for(int i =0;i<Dictionary.size();i++)
            visited.add(false);

        ArrayList<String> DFS = new ArrayList<>(); //list of words to be returned
        stack.push(sourceNode);
        boolean pathFound = false;

        while(!stack.isEmpty()){
            String s = stack.pop(); //get last word pushed to stack
            int indexInMatrix = Dictionary.indexOf(s);
            if(!visited.get(indexInMatrix)){ //if that word has not been visited yet
                DFS.add(s); //add it to the word ladder
                if(s.equals(endNode)){ //found our way to the destination word
                    pathFound = true;
                    break;
                }
                visited.set(indexInMatrix,true); //if not done looking yet, set that word to "visited"
                for(int i = 0;i<numNodes;i++){
                    if (AdjMatrix.get(indexInMatrix).get(i) && !visited.get(i)){
                        stack.push(Dictionary.get(i));
                    }
                }
            }
        }

        if(pathFound)
            return DFS;
        else {
            ArrayList<String> empty = new ArrayList<>();
            return empty;
        }
    }

    public ArrayList<String> BFS(String sourceNode,String endNode){
        //Data structures needed for BFS
        Queue<String> queue = new LinkedList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<String> Parent = new ArrayList<>();
        ArrayList<String> BFS = new ArrayList<>();

        //Set discovered for all nodes to false
        //Set parent for all nodes to null
        for(int i =0;i<Dictionary.size();i++){
            visited.add(false);
            Parent.add(null);
        }

        //Add starting node to a queue
        queue.add(sourceNode);
        boolean pathFound = false;

        while(!queue.isEmpty()){
            String head = queue.poll(); //deQueue the head of the queue
            if(head.equals(endNode)){ //if head == value found
                pathFound = true;
                break;
            }
            int indexInMatrix = Dictionary.indexOf(head);
            for(int i = 0;i<numNodes;i++){ //for each neighbor of head
                if (AdjMatrix.get(indexInMatrix).get(i) && !visited.get(i) && Parent.get(i) == null){
                    visited.set(i,true);
                    Parent.set(i,head);
                    queue.add(Dictionary.get(i));
                }
            }
        }
        if(!pathFound){
            BFS.add(sourceNode.toLowerCase());
            BFS.add(endNode.toLowerCase());
            return BFS;
        }
        else{
            String temp = endNode;
            while(!temp.equals(sourceNode)){
                BFS.add(temp.toLowerCase());
                temp = Parent.get(Dictionary.indexOf(temp));
            }
            BFS.add(sourceNode);
            Collections.reverse(BFS);
            return BFS;
        }
    }
}
