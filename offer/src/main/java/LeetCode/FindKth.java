package LeetCode;

public class FindKth {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            /*
            * 快排找第K大的元素
            * */
         /*
            找第k大的元素，假如元素从小到大排好序，也就是找元素索引是target=nums.length - k的元素
            1. 需要一个Partition函数，找到index，左<index<右
            public int partition(int[] nums, int start, int end)
            2. 判断index == target？退出，返回nums[target]: 递归处理index左侧或者右侧的元素
            3. 若index < target,递归处理index右边的元素；
               若index > target,递归处理index左边的元素；
               递归结束的条件就是index == target

            边界值判断：
            nums == null; nums.length <=0; num.length < k;
        */
            if (nums == null || nums.length <= 0 || nums.length < k) {
                return 0;
            }
            int length = nums.length;
            if (length == 1 && k == 1) {
                return nums[0];
            }
            int target = length - k;
            return findKth(nums, 0, length - 1, target);
        }
        public int findKth(int[] nums, int start, int end, int target) {
            int index = partition(nums, start, end);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                return findKth(nums, index + 1, end, target);//注意此处的index一定要+1，不然会造成递归栈溢出
            } else {
                return findKth(nums, start, index - 1, target);
            }
        }
        /*
        * partition函数返回的是基准元素所在数组的索引，这个是书中的方法
        * 先将基准元素移到数组末尾，找到基准元素应该在的位置之后再交换
        * */
        public int partition(int[] nums, int start, int end) {
            if (nums == null || nums.length <= 0 || start < 0 || end >= nums.length) {
                return 0;
            }
            //int index = start + (int)(Math.random() * (end-start+1));
            int index = start; //每次传入的数组开始和结束位置都不一样，因此index也是一个变量，不能设置为index = 0
            swap(nums, index, end);
            int small = start - 1;
            for (index = start; index < end; ++index) {
                if (nums[index] < nums[end]) {
                    ++small;
                    if (small != index) {
                        swap(nums, index, small);
                    }
                }
            }
            ++small;
            swap(nums, small, end);
            return small;
        }
        /*
        * 使用两端探测+分治法实现的partition函数
        * */
        public int Partition2(int[] nums, int start, int end) {
            /*使用两端探测交换+分治法*/
            int index = nums[start];
            int left = start;
            int right = end;
            while (left != right) {
                while (nums[right] >= index && left <right)
                    right--;
                while (nums[left] <= index && left <right)
                    left++;
                if (left < right) {
                    swap(nums, left, right);
                }
            }
            swap(nums, start, left);
            return left;
        }
        public void swap(int[] nums, int num1, int num2) {
            //交换的是数组中两个元素的值，不能只是交换值，这样方法退出之后，数组元素还是没有变化
            int temp = nums[num1];
            nums[num1] = nums[num2];
            nums[num2] = temp;
        }
    }
}
