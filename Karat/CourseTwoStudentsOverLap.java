package Karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Sample Input:

student_course_pairs_1 = [
  ["58", "Software Design"],
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
]

Sample Output (pseudocode, in any order):

find_pairs(student_course_pairs_1) =>
{
  [58, 17]: ["Software Design", "Linear Algebra"]
  [58, 94]: ["Economics"]
  [58, 25]: ["Economics"]
  [94, 25]: ["Economics"]
  [17, 94]: []
  [17, 25]: []
}

Additional test cases:

Sample Input:

student_course_pairs_2 = [
  ["42", "Software Design"],
  ["0", "Advanced Mechanics"],
  ["9", "Art History"],
]

Sample output:

find_pairs(student_course_pairs_2) =>
{
  [0, 42]: []
  [0, 9]: []
  [9, 42]: []
}
 */
public class CourseTwoStudentsOverLap {

    public static void courseOverlaps(List<String[]> studentCoursePair){

        HashMap<String, Set<String>> coursesMap = new HashMap<>();

        for(String[] pair:studentCoursePair){
            if(!coursesMap.containsKey(pair[0]))
                coursesMap.put(pair[0], coursesMap.getOrDefault(pair[0],new HashSet<>()));
            coursesMap.get(pair[0]).add(pair[1]);
        }
        ArrayList<String> studentIds = new ArrayList<>(coursesMap.keySet());
        for (int i=0;i<studentIds.size();i++) {
            for (int j = i+1; j < studentIds.size(); j++) {
                System.out.println("[" + studentIds.get(i) + " , " + studentIds.get(j) + "]" +
                                coursesMap.get(studentIds.get(i)).stream()
                                        .filter(coursesMap.get(studentIds.get(j))::contains)
                                        .collect(Collectors.toList())
                      );
            }
        }

    }


    public static void main(String[] args) {
        List<String[]> studentCoursePair = Arrays.asList(
                            new String[]{"58", "Software Design"},
                            new String[]{"58", "Linear Algebra"},
                            new String[]{"94", "Art History"},
                            new String[]{"94", "Operating Systems"},
                            new String[]{"17", "Software Design"},
                            new String[]{"58", "Mechanics"},
                            new String[]{"58", "Economics"},
                            new String[]{"17", "Linear Algebra"},
                            new String[]{"17", "Political Science"},
                            new String[]{"94", "Economics"},
                            new String[]{"25", "Economics"}
                        );
        courseOverlaps(studentCoursePair);
    }
}
