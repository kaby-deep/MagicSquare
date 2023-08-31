//magic square constant is [n*(n^2 +1)]/2
//https://www.wikihow.com/Solve-a-Magic-Square
//following the algorithm given in the above link
import java.util.*;

public class magicSQ
{
    int matx[][];
    int n;
    
    public magicSQ()
    {
        n=0;
    }
    
    void entry()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value of n: ");
        n=sc.nextInt();
        matx=new int[n][n];
    }
    
    void fill()
    {
        if(n%2==1)  //for an odd numbered magic square
        {
           int x=0;
           int y=n/2;
           
           for(int i=0;i<(n*n);i++)
           {
               int num=i+1;
               matx[x][y]=num;
               int tx=x;
               int ty=y;
               if((x-1)<0)
               x=(n-1);
               else
               x=x-1;
               
               if((y+1)==n)
               y=0;
               else
               y=y+1;
               
               if(matx[x][y]!=0)
               {
                   x=tx+1;
                   y=ty;
               }
           }
        }
        else if(n%2==0 && n%4!=0)  //for an singly even magic square
        { 
            int x=0;
            int y=n/4;
            int count=0;
            for(int i=0;i<((n/2)*(n/2));i++)
            {
               int num=1+i;
               count=num;
               matx[x][y]=num;
               int tx=x;
               int ty=y;
               if((x-1)<0)
               x=((n/2)-1);
               else
               x=x-1;
               
               if((y+1)==n/2)
               y=0;
               else
               y=y+1;
               
               if(matx[x][y]!=0)
               {
                   x=tx+1;
                   y=ty;
               }
            }
            
            x=n/2;
            y=(3*n)/4;
            
            for(int i=count;i<((n/2)*(n/2))*2;i++)
            {
               int num=1+i;
               count=num;
               matx[x][y]=num;
               int tx=x;
               int ty=y;
               if((x-1)<(n/2))
               x=(n-1);
               else
               x=x-1;
               
               if((y+1)==n)
               y=n/2;
               else
               y=y+1;
               
               if(matx[x][y]!=0)
               {
                   x=tx+1;
                   y=ty;
               }
            }
            
            x=0;
            y=(3*n)/4;
            
            for(int i=count;i<((n/2)*(n/2))*3;i++)
            {
               int num=1+i;
               count=num;
               matx[x][y]=num;
               int tx=x;
               int ty=y;
               if((x-1)<0)
                x=((n/2)-1);
               else
                x=x-1;
               
               if((y+1)==n)
               y=(n/2);
               else
               y=y+1;
               
               if(matx[x][y]!=0)
               {
                   x=tx+1;
                   y=ty;
               }
            }
            
            x=n/2;
            y=n/4;
            
            for(int i=count;i<((n/2)*(n/2))*4;i++)
            {
               int num=1+i;
               count=num;
               matx[x][y]=num;
               int tx=x;
               int ty=y;
               if((x-1)<(n/2))
               x=(n-1);
               else
               x=x-1;
               
               if((y+1)==n/2)
               y=0;
               else
               y=y+1;
               
               if(matx[x][y]!=0)
               {
                   x=tx+1;
                   y=ty;
               }
            }
        }
        else  //for an doubly even magic square
        {
             for(int i=0;i<n/4;i++)
             {
                 for(int j=0;j<n/4;j++)
                 matx[i][j]=-1;
             }
             for(int i=0;i<n/4;i++)
             {
                 for(int j=3*(n/4);j<n;j++)
                 matx[i][j]=-1;
             }
             for(int i=3*(n/4);i<n;i++)
             {
                 for(int j=0;j<n/4;j++)
                 matx[i][j]=-1;
             }
             for(int i=3*(n/4);i<n;i++)
             {
                 for(int j=3*(n/4);j<n;j++)
                 matx[i][j]=-1;
             }
             
             for(int i=n/4;i<3*(n/4);i++)
             {
                 for(int j=n/4;j<3*(n/4);j++)
                 matx[i][j]=-1;
             }
             int count=1;
             for(int i=0;i<n;i++)
             {
                 for(int j=0;j<n;j++)
                 {
                     if(matx[i][j]==-1)
                     matx[i][j]=count;
                     
                     count+=1;
                 }
             }
             int count2=n*n;
             for(int i=0;i<n;i++)
             {
                 for(int j=0;j<n;j++)
                 {
                     if(matx[i][j]==0)
                     matx[i][j]=count2;
                     
                     count2-=1;
                 }
             }
        }
    }
    
    
    void dispaly()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matx[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[])
    {
        magicSQ ob=new magicSQ();
        ob.entry();
        ob.fill();
        ob.dispaly();
    }
}