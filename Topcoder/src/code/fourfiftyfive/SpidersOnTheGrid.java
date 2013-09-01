package code.fourfiftyfive;
public class SpidersOnTheGrid{
	public static void main(String[] args) {
		SpidersOnTheGrid s = new SpidersOnTheGrid();
		String[] A = {"EW","NN"};
		System.out.println(s.find(A));
	}
	public int find(String[] A){
		int count=0;
		int al=A.length,sl=A[0].length();
		char c[][] = new char[al][sl];
		for(int i=0;i<al;i++){
			for(int j=0;j<sl;j++){
				if(A[i].charAt(j)=='N' && i-1>=0)
					c[i-1][j]='.';
				if(A[i].charAt(j)=='S' && i+1<al)
					 c[i+1][j]='.';
			    if(A[i].charAt(j)=='E' && j+1<sl)
					 c[i][j+1]='.';
			    if(A[i].charAt(j)=='W' && j-1>=0)
					 c[i][j-1]='.';					 
			}			
		}
		for(int i=0;i<al;i++)
			for(int j=0;j<sl;j++)
				if(c[i][j]!='.')
					count++;
		return count;
	}
}