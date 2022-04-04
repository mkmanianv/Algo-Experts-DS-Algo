package arrays;

public class CanJump {

    public boolean canJump(int[] nums) {
       int lastGoodIndexPos= nums.length-1;
       for(int i=nums.length-1;i>=0;i--){
           if(i+nums[i] >=lastGoodIndexPos){
               lastGoodIndexPos=i;
           }
       }
       return lastGoodIndexPos == 0;

    }

    public static void main(String[] args) {
        new CanJump().canJump(new int[]{2,3,1,1,4});
    }
}
