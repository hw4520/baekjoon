import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B10825 {
    // arrayList 대신 배열로 해도 된다.

    static class Student implements Comparable<Student>{
        private String name;
        private int koreanScore;
        private int englishScore;
        private int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKoreanScore() {
            return koreanScore;
        }

        public void setKoreanScore(int koreanScore) {
            this.koreanScore = koreanScore;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(int englishScore) {
            this.englishScore = englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }

        public void setMathScore(int mathScore) {
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student object) {
            if(this.koreanScore != object.getKoreanScore()) {
                return object.getKoreanScore() - this.koreanScore;
            }
            if(this.englishScore != object.getEnglishScore()) {
                return this.englishScore - object.getEnglishScore();
            }
            if(this.mathScore != object.getMathScore()) {
                return object.getMathScore() - this.mathScore;
            }

            return compareName(this.name, object.getName());
        }

        public int compareName(String name, String targetName) {
            char[] nameInitialGroup = name.toCharArray();
            char[] targetNameInitialGroup = targetName.toCharArray();
            for(int i = 0; i < 10; i++) {
                if(nameInitialGroup[i] < targetNameInitialGroup[i]) {
                    return -1;
                }
                if(nameInitialGroup[i] > targetNameInitialGroup[i]) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static int N;
    public static List<Student> studentList;

    public static void main(String[] args) {
        initializeData();
        studentList.sort(Student::compareTo);
        for (Student student:studentList) {
            System.out.println(student.getName());
        }
    }

    // 초기화
    public static void initializeData() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        studentList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            Student student = new Student(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            studentList.add(student);
        }
    }

}
