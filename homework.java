package homework;
import java.io.*;
public class homework {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {          
       FileReader reader = new FileReader("src\\homework\\input.txt");
        BufferedReader in   = new BufferedReader(reader);
        String alg;
        alg = in.readLine();             
        switch(alg)
        {
            case "BFS":
                new bfs(new val(in));
                break;
            case "UCS":
                new ucs(new val(in));
                break;
            case "A*":
                new astar(new val(in));
                break;
            default:                
                new val(in).print(0);
        }
    }    
}

