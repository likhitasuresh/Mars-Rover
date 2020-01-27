package homework;
import java.io.*;
import java.util.*;
public class bfs {
    ArrayList<mapnode> q;
    int[][] vis;
    int i, j, flag;
    mapnode pop;
    String[] paths;
    bfs(val po) throws IOException
    {
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
      q.add(po.map[i][j]);
      do
      {
          if(q.isEmpty())  
          {
            po.print(0);
          }                 
          pop = q.remove(0);                 
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
          if(i<po.h && j<po.w && i>=0 && j>=0)
          {
              if(i-1>=0 && (Math.abs(po.map[i][j].curr.val-po.map[i-1][j].curr.val)) <= po.maxz && vis[i-1][j]!=1 )
              {
                  vis[i-1][j] = 1;
                  po.map[i-1][j].parent = po.map[i][j].curr;                  
                  q.add(po.map[i-1][j]);
              }
              if( i+1< po.h && Math.abs(po.map[i][j].curr.val-po.map[i+1][j].curr.val) <= po.maxz && vis[i+1][j]!=1 )
              {
                  vis[i+1][j] = 1;
                  po.map[i+1][j].parent = po.map[i][j].curr;                  
                  q.add(po.map[i+1][j]);
              }
              if( i-1>=0 && j-1>=0 && Math.abs(po.map[i][j].curr.val-po.map[i-1][j-1].curr.val) <= po.maxz && vis[i-1][j-1]!=1 )
              {
                  vis[i-1][j-1] = 1;
                  po.map[i-1][j-1].parent = po.map[i][j].curr;                  
                  q.add(po.map[i-1][j-1]);
              }
              if( i-1>=0 && j+1<po.w && Math.abs(po.map[i][j].curr.val-po.map[i-1][j+1].curr.val) <= po.maxz && vis[i-1][j+1]!=1 )
              {
                  vis[i-1][j+1] = 1;                  
                  po.map[i-1][j+1].parent = po.map[i][j].curr;                  
                  q.add(po.map[i-1][j+1]);
              }
                  
              if(j-1>=0 && Math.abs(po.map[i][j].curr.val-po.map[i][j-1].curr.val) <= po.maxz && vis[i][j-1]!=1 )
              {                 
                  vis[i][j-1] = 1;
                  po.map[i][j-1].parent = po.map[i][j].curr;                  
                  q.add(po.map[i][j-1]);
              }
               if(j+1<po.w && Math.abs(po.map[i][j].curr.val-po.map[i][j+1].curr.val) <= po.maxz && vis[i][j+1]!=1 )
              {
                  vis[i][j+1] = 1;
                  po.map[i][j+1].parent = po.map[i][j].curr;                  
                  q.add(po.map[i][j+1]);
                  
              } 
                if(i+1<po.h && j-1>=0 && Math.abs(po.map[i][j].curr.val-po.map[i+1][j-1].curr.val) <= po.maxz && vis[i+1][j-1]!=1 )
              {
                  vis[i+1][j-1] = 1;
                  po.map[i+1][j-1].parent = po.map[i][j].curr;                  
                  q.add(po.map[i+1][j-1]);
              }
                 if(i+1<po.h && j+1<po.w && Math.abs(po.map[i][j].curr.val-po.map[i+1][j+1].curr.val) <= po.maxz && vis[i+1][j+1]!=1 )
              {
                  vis[i+1][j+1] = 1;
                  po.map[i+1][j+1].parent = po.map[i][j].curr;                  
                  q.add(po.map[i+1][j+1]);
              }   
                 
               /*for(int m=0;m<po.t;m++)
               {
                   if(i==po.tar[m][0] && j==po.tar[m][1])
                   {
                       po.tar[m][0]=po.tar[m][1]=-1;                       
                       flag--;                       
                       paths = po.putInPath(i, j, m);                                                         
                    }                  
               }  */                                      
          }
      }while(flag!=0);
      po.print(paths);     
    }
    
    
}
