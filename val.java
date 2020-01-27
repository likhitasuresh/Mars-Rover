package homework;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class val {  
    BufferedReader in;
    FileWriter outf;
    String alg, wh[], xy[], tw[];
    int w, h, x, y, maxz, t;
    int tar[][];
    mapnode map[][];
    List <ArrayList<qnode>> path; 
    static String[] paths;
    BufferedWriter writer;    
    public val(BufferedReader in) throws FileNotFoundException, IOException
    {
        writer = new BufferedWriter(new FileWriter("output.txt"));
        wh = in.readLine().split(" "); 
        xy = in.readLine().split(" ");
        w = Integer.parseInt(wh[0]);
        h = Integer.parseInt(wh[1]);        
        y = Integer.parseInt(xy[0]);
        x = Integer.parseInt(xy[1]);
        maxz = Integer.parseInt(in.readLine()); 
        t = Integer.parseInt(in.readLine());
        tar = new int[t][2];
        for(int i=0;i<t;i++)
        {
            int k=0;
            tw = new String[2];
            tw = in.readLine().split(" ");             
                tar[i][1]= Integer.parseInt(tw[k++]);
                tar[i][0]= Integer.parseInt(tw[k]);
        }
        map=new mapnode[h][w];        
        for(int i=0;i<h;i++)
        {
            tw = new String[w];
            tw = in.readLine().split(" ");            
            for(int j=0;j<w;j++)  
            {
                map[i][j] = new mapnode();              
                map[i][j].curr.val=Integer.parseInt(tw[j]);   
                map[i][j].curr.x=i;
                map[i][j].curr.y=j;
            }         
        }
         paths = new String[t];
         for(int o=0;o<t;o++)
         {
             paths[o]="";
         }
    }
    public val(val v)
    {
        this.w = v.w;
        this.h = v.h;
        this.x = v.x;
        this.y = v.y;
        this.maxz = v.maxz;
        this.t = v.t;
        this.tar = new int[v.t][2];
        for(int i=0;i<v.t;i++)
            for(int j=0;j<2;j++)
                this.tar[i][j] = v.tar[i][j];
        this.map = new mapnode[v.h][v.w];        
        for(int i=0;i<v.h;i++)
            for(int j=0;j<v.w;j++)
            {
                this.map[i][j] = new mapnode();
                this.map[i][j].curr = new qnode(v.map[i][j].curr.x,v.map[i][j].curr.y,v.map[i][j].curr.val,v.map[i][j].curr.dis);
                this.map[i][j].parent = new qnode(v.map[i][j].parent.x,v.map[i][j].parent.y,v.map[i][j].parent.val,v.map[i][j].parent.dis);                
            }        
    }
    public String[] putInPath(int tx, int ty, int pos) throws IOException
    {
        ArrayList<qnode> p1 = new ArrayList<qnode>();         
        while(map[tx][ty].parent.x!=-1&& map[tx][ty].parent.y!=-1 )
        {           
           p1.add(0,map[tx][ty].curr);          
           int df, fd;
           df = map[tx][ty].parent.x;
           fd = map[tx][ty].parent.y;  
           tx = df;
           ty = fd;                           
         }
        p1.add(0,map[tx][ty].curr);   
        for(int pq=0;pq<p1.size();pq++)
         {
             paths[pos]= paths[pos]+ p1.get(pq).y+","+p1.get(pq).x+" ";    
         }
         paths[pos]= paths[pos]+"\n";         
          return paths;       
    }
    public void print(String []paths) throws IOException
    {
        int you;
        outf = new FileWriter("src\\homework\\output.txt");        
        for (you=0;you<paths.length-1;you++) {           
            outf.write(paths[you]);
        }  
        outf.write(paths[you].trim());        
        outf.close();
    }
    public void print(int noPath) throws IOException
    {        
        outf = new FileWriter("src\\homework\\output.txt");                      
        outf.write("FAIL");                     
        outf.close();
        System.exit(0);
    }
  }

