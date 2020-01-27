package homework;
public class qnode {
    int x, y, val, dis;
    public qnode(int x, int y, int val, int dis)
    {
        this.x = x;
        this.y = y;
        this.val = val;
        this.dis = dis;
    }
    public qnode()
    {
        x=y=val=-1;
        dis=0;
    }
    public qnode(qnode r)
    {
        this.x = r.x;
       this.y = r.y;
       this.val = r.val;
       this.dis = r.dis;
    }
}
