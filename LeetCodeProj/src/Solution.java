import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;



	public class Solution {
		public static void main(String[] args){	
			LinkedList<Integer> list1 = new LinkedList<Integer>();
			
			System.out.println( list1.size() );
			
			list1.add( null );
			
			System.out.println( list1.size() );
			
			Integer ele = list1.getFirst();
			
			System.out.println( ele );
			
			System.exit(0);
			
			int c = 12;
			int b = 8 % 10;
			
			System.out.println( b);
			System.exit(0);
			
			
			Solution solu = new Solution();
			
			TreeNode n1 = new TreeNode(1);			
			TreeNode n2 = new TreeNode(2);
			TreeNode n5 = new TreeNode(5);
			TreeNode n3 = new TreeNode(3);
			TreeNode n4 = new TreeNode(4);
			TreeNode n6 = new TreeNode(6);
			
			n1.left = n2;
//			n1.right = n2;
			
//			n1.right = n5;
//			
//			n2.left = n3;
//			n2.right = n4;
//			
//			n5.right = n6;
			
//			solu.flatten(n1);
//			
//			TreeNode n = n1;
//			
//			while( n != null ){
//				System.out.print( n.val + " ");
//				n = n.right;
//			}
//
//			n = n2;
//			while( n != null ){
//				System.out.print( n.val + " ");
//				n = n.left;
//			}
			
//			int[] c = {2};
//			solu.combinationSum(c, 1);
			
			
//			int[] arr = new int[3];
//			for(int a : arr){
//				System.out.println(a);
//			}
			
			TreeNode[] arr = new TreeNode[1];
			arr[0] = new TreeNode(10);
			for(TreeNode a : arr){
				System.out.println(a.val);
			}
			
		}
		
		  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		        if( candidates == null || candidates.length == 0 || target < 0 )
		            return null;

		        ArrayList<ArrayList<Integer>> allLists = new ArrayList<ArrayList<Integer>>();

		        
		        if( target == 0 ){
		            allLists.add( new ArrayList<Integer>() );
		            return allLists;
		        }
		        
		        if( target < 0 )
		            return allLists;
		        
		        
		        for(int i = 0; i < candidates.length; i++){
		            int val = candidates[i];
		            
		            ArrayList<ArrayList<Integer>> partialLists = combinationSum(candidates, target - val );
		            
		            for(ArrayList<Integer> list : partialLists){
		                if( list.isEmpty() || (val >= list.get(list.size()-1) ) ){
		                    list.add( val );
		                    
		                    allLists.add( list );
		                }
		            }
		        }
		        
		        return allLists;
		    }
	
	}



