
public class Algorithms {

	public void Linear_Search(int[] array , int key)
	{
		int i,k=0;
		for( i=0 ; i<array.length; i++ )
		{
			if(key==array[i]){
				System.out.println("Match Found at Location = "+ (i+1));
			}
			else{
				k++;
			}
		}
		if(k==array.length)		{System.out.println("MATCH NOT FOUND");	}
	}
//*****************************************************************************************//	1

	public static void Binary_Search(int array[], int key) {

		int l = -1;
		int r= array.length+1;
		int mid;
		mid = (l+r)/2;
		int loc = -1;                       //key not Found

		while(r > l+1 )
		{
			if( array[mid]  == key )
			{loc = mid + 1 ; break;	}

			else if ( array[mid] > key )
			{ r = mid ; mid = (l+r)/2;	}

			else
			{ l = mid ; mid = (l+r)/2;	}

		}

		if(loc != -1)
		{	System.out.println("Match found at location= " + loc );			}

		else
		{	System.out.println("MATCH NOT FOUND");							}

	}
//*****************************************************************************************//	2
	public void Insertion_Sort ( int[] array ){

		int i,j,key,temp;

		for( i=1; i<array.length; i++ ){

			key = array[i];
			j = i-1;

			while( j>=0 && key < array[j] ){

				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
			}
		}

		for( int k=0; k<array.length; k++){
			System.out.println(array[k]);
		}
	}
//*****************************************************************************************//	3
	public static void Selection_Sort (int A[]){

		for(int k=0; k<A.length; k++){
			int temp = minimum(A, k);
			swap(A, k , temp);
		}

		for( int k=0; k<A.length; k++){
			System.out.println(A[k]);
		}

	}

	public static void swap(int A[], int x, int y) {
		int temp;

		temp = A[x];
		A[x] = A[y];
		A[y] = temp;

	}


	public static int minimum(int A[], int k){
		int m = k;
		int minValue = A[k];
		for (int j = k; j<A.length; j++){

			if(minValue > A[j]){
				minValue = A[j];
				m = j;
			}
		}
		return m;
	}
//*****************************************************************************************//	4
	public static void Radix_Sort(int[] array) {

		int a[] = new int [100],large =0,l=0;
		int n=array.length;
		int i,j,p,k;

		for(i=0;i<n;i++)
			if(large<array[i]) large = array[i];
		k=large;
		while(k!=0){
			l++;
			k=k/10;
		}

		int z =10;
		while(l>0){
			for(i=0;i<n;i++)
			{
				p = i;
				for(j=i+1;j<n;j++){
					if(array[p] % z>array[j]%z)
					{
						int temp; 

						temp = array[p];
						array[p] = array[j];
						array[j] = temp;
					}
				}
			}
			l--;z=z*10;	
		}
		for(i=0;i<n;i++)
			//HEXADECIMAL OUTPUT System.out.println(Integer.toHexString(array[i]));
			System.out.println(array[i]);
	}
//*****************************************************************************************//	5
	public static void Quick_Sort(int[] array){

		Quick_Sorting(array,0,array.length-1);
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}
	
	public static void Quick_Sorting(int b[], int p, int r){

		if(p<r){
			int q = partition(b,p,r);
			Quick_Sorting(b, p, q-1);
			Quick_Sorting(b, q+1, r);
		}
	}

	public static int partition(int a[], int p, int r){

		int  x = a[r];
		int i = p-1;

		for ( int j = p; j<r ; j++){

			if( a[j] <= x ){

				i++;
				swap_1( a, i, j);
			}
		}
		swap_1(a, i+1, r);
		return i+1;
	}


	public static void swap_1(int y[], int m, int n){
		int temp;

		temp = y[m];
		y[m] = y[n];
		y[n] = temp;
	}
//*****************************************************************************************//   6

public class Heap_Sort 
{
	int[] array;
	int n;
	int left;
	int right;
	int largest;
 
    public void sort(int[] array){
       // array=a0;
        buildheap(array);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(array, 0);
        }
    }
    
    public void buildheap(int[] array){
        n=array.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(array,i);
        }
    }
    
    public void maxheap(int[] array, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && array[left] > array[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && array[right] > array[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(array, largest);
        }
    }
    
    public void exchange(int i, int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t; 
        }

}
//*****************************************************************************************//  7
	public static void Merge_Sort(int[] array){

		Merge_Sorting(array,0,array.length-1);
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}

	public static void Merge_Sorting(int array[],int p,int r){
		if(p<r){
			int k = (p+r)/2;
			Merge_Sorting(array,p,k);
			Merge_Sorting(array,k+1,r);
			Merging(array,p,k,r);
		}
	}

	public static void Merging(int array[],int p,int q,int h) {
		int n1 = (q-p )+ 1;int i,k;
		int n2 = (h-q);
		int l[] = new int [100]; int r[] = new int [100];
		for(i=0;i<n1;i++){
			l[i] = array[p+i];}l[n1] =1000000000;

			for(i=0;i<n2;i++){
				r[i] = array[q+i+1];}r[n2] = 100000000;

				i = 0;int j = 0;
				for(k=p;k<=h;k++)
				{
					if(l[i]<=r[j]){
						array[k] = l[i];
						i=i+1;
					}
					else{
						array[k] = r[j];
						j = j+1;
					}
				}
	}
//*****************************************************************************************//   8





}
