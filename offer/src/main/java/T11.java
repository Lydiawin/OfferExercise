public class T11 {

    /*
    * T11: 数值的整数次方
    * 题目描述:
    * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    * */
    public class Solution {
        /*
            本题有很多边界条件需要考虑
            1. base和exponent为0，0的0次方无意义，其余数的0次方为1；
            2. exponent为负数，求次方后需要取倒数，如果base为0，0不可以做除数；
            3. base为doubule类型，判断base为0需要考虑考虑；
            4. 求次方，可以使用公式，exponent分为奇偶数;
            5. 位运算的效率比乘除法，求余运算的效率高很多！
            注意:在比较double类型数值是否相等时，不能直接使用base==0，因为计算机在存储小数时都会有误差，
            只能判断它们之间的差值的绝对值是不是在一个很小的范围内，如果两个数相差很小，就可以认为他们相等。
        */
        public double Power(double base, int exponent) {
            boolean invalidInPut = false;
            int absExponent = exponent;
            if (equal(base, 0.0) && exponent == 0) return 0;
            if (equal(base, 0.0) && exponent < 0) {
                invalidInPut = true;
                return 0;
            }
            if (exponent < 0) {
                absExponent = -exponent;
            }
            if (exponent == 1) {
                return base;
            }
            double result = PowerWithUnsignedExponent(base, absExponent);
            if (exponent < 0) {
                result = 1.0 / result;
            }
            return result;
        }
        public boolean equal(double num1, double num2) {
            if ((num1 - num2 > -0.000001) && (num1 - num2 < 0.000001)) {
                return true;
            } else {
                return false;
            }
        }
        public double PowerWithUnsignedExponent(double base, int exponent) {
            if (exponent == 0) {
                return 1;
            }
            if (exponent == 1) {
                return base;
            }
            double result = PowerWithUnsignedExponent(base, exponent >> 1);
            result *= result;
            if ((exponent & 0x01) == 1) {
                result *= base;
            }
            return result;
        }
    }
}
