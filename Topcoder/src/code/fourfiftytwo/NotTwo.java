package code.fourfiftytwo;

public class NotTwo {
	public static void main(String[] args) {
		int i = 1000000007;
		System.out.println(i);
	}

	public int maxStones(int width, int height){
			int a[][] = new int[height][width];
			int m=height,n=width;
			int count=0;
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
					a[i][j]='-';
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(((i-2)<0 || (a[i-2][j]!='*')) && ((j-2)<0||(a[i][j-2]!='*'))){
						a[i][j]='*';
						count++;
					}
				}
			}
			return count;
		}
}
