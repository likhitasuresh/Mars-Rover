package homework;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ucs {
    ArrayList<mapnode> q;
    int[][] vis;
    int i, j, flag;
    mapnode next, pop, test;
    FileWriter outf;
    String[] paths;
    val po;
    ucs (val popp) throws IOException
    {
      po= new val(popp);
      pop = new mapnode();
      q = new ArrayList<>();
      vis = new int[po.h][po.w];
      for(int l=0;l<po.h;l++)
          for(int m=0;m<po.w;m++)
          {
              vis[l][m]=-1;             
          }
      i=po.x;
      j=po.y;
      flag = po.t;
      vis[i][j]=1;      
      for(int w=0;w<po.h;w++)
      {
          for(int e=0;e<po.w;e++)
          {
              po.map[w][e].curr.dis=5000;
          }
      }
      po.map[i][j].curr.dis=0;      
      q.add(po.map[i][j]);
      do
      {
         if(q.isEmpty())          
              po.print(0);              
          pop = new mapnode (fSmall());                    
          i = pop.curr.x;
          j = pop.curr.y;          
          for(int m=0;m<po.t;m++)
               {
                   if(i==po.tar[m][0] && j==po.tar[m][1])
                   {
                       po.tar[m][0]=po.tar[m][1]=-1;                       
                       flag--;                        
                       paths = po.putInPath(i, j, m); 
                    }                  
               }                            
          if(i-1>=0 && vis[i-1][j]!=1)
           bigIf(i-1,j);
          if(i+1<po.h && vis[i+1][j]!=1)
           bigIf(i+1,j);
          if(j+1<po.w && vis[i][j+1]!=1)
           bigIf(i,j+1);
          if(j-1>=0 && vis[i][j-1]!=1)                     
           bigIf(i,j-1);                     
          if(i-1>=0 && j-1>=0 && vis[i-1][j-1]!=1)
           bigIf(i-1,j-1);
          if(i-1>=0 && j+1<po.w && vis[i-1][j+1]!=1)
           bigIf(i-1,j+1);
          if(i+1<po.h && j-1>=0 && vis[i+1][j-1]!=1)
           bigIf(i+1,j-1);
          if(i+1<po.h && j+1<po.w && vis[i+1][j+1]!=1)
           bigIf(i+1,j+1);          
      }while(flag!=0);
      po.print(paths);
    }
    public mapnode fSmall() throws IOException
    {
        mapnode a;  
        if(q.isEmpty())          
              po.print(0);
        a = new mapnode(q.get(0));        
        for(int g=0;g<q.size();g++)
        {            
            if(a.curr.dis >= q.get(g).curr.dis)
            {
                a = new mapnode(q.get(g));                             
            }
        }        
       q.remove(a);                    
       vis[a.curr.x][a.curr.y]=1;       
        return a;
    }
    public void bigIf(int hi, int hj) throws IOException
    {
        int indicator=5000, qa, fdis=0;
        test = new mapnode(po.map[hi][hj]);                
        if((Math.abs(po.map[i][j].curr.val-test.curr.val)) <= po.maxz)
          {                                
              if(hi==i || hj==j)
              {
                  po.map[hi][hj].curr.dis = po.map[i][j].curr.dis+10;                  
              }
              else if(hi!=i && hj!=j)
              {
                 po.map[hi][hj].curr.dis = po.map[i][j].curr.dis+14; 
              }   
              test.curr.dis = po.map[hi][hj].curr.dis;              
              for(qa=0;qa<q.size();qa++)
              {                  
                      if(q.get(qa).curr.x == hi && q.get(qa).curr.y == hj)
                      {
                         indicator=3000; 
                         fdis = q.get(qa).curr.dis;                         
                         break;
                  }
              }
              if(vis[hi][hj]!=1 && indicator==5000)
                {
                    po.map[hi][hj].parent = new qnode(po.map[i][j].curr) ;
                    test.parent = new qnode(po.map[hi][hj].parent);                                        
                    q.add(0,test);                     
                }
              else if(indicator==3000)              
                {                                                      
                    if(fdis>po.map[hi][hj].curr.dis)
                      {
                       if(q.isEmpty())          
                          po.print(0);
                       q.remove(qa);
                       po.map[hi][hj].parent = new qnode(po.map[i][j].curr) ;
                       test.parent = new qnode(po.map[hi][hj].parent);                        
                       q.add(qa,test);                      
                      }
                    po.map[hi][hj].curr.dis=fdis;
                }                                             
          }
    }
       
}
