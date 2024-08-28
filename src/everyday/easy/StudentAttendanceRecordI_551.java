package everyday.easy;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/18 下午12:55
 */
public class StudentAttendanceRecordI_551 {
    public boolean checkRecord(String s) {
        int absent = 0 ,  late = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'L'){
                late = 0;
                if (s.charAt(i) == 'A') {
                    absent++;
                    if(absent >= 2) return false;
                }
            }else {
                late++;
                if (late >= 3) return false;
            }
        }
        return true;
    }
}
