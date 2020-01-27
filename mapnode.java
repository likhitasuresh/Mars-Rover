package homework;

public class mapnode {
   qnode parent, curr;
   public mapnode(qnode parent, qnode curr)
   {
       this.parent = parent;
       this.curr = curr;
   }
   public mapnode()
   {
       parent = new qnode();
       curr = new qnode();
   }
   public mapnode(mapnode t)
   {
       this.parent = new qnode(t.parent.x,t.parent.y,t.parent.val,t.parent.dis);
       this.curr = new qnode(t.curr.x,t.curr.y,t.curr.val,t.curr.dis);
   }
   
   @Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if ((o instanceof mapnode)) { 
            if(((mapnode) o).curr.x == this.curr.x && ((mapnode) o).curr.y == this.curr.y)
                return true;
        } 
          
        return false; 
    } 
    
}
