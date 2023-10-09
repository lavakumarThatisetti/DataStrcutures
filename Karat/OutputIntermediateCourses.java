package Karat;
/*
Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum.
There may be more than one track that includes the same course, but each student follows a single linear track
from a "root" node to a "leaf" node. In the graph below, their path always moves left to right.

Each course at our university has at most one prerequisite that must be taken first.
No two courses share a prerequisite.  There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name  of the course
that the student will be taking when they are halfway through their program.
(If a track has an even number of courses, and therefore has two "middle" courses,
you should return the first one.)



Sample input:
all_courses = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output (in any order):
          ["Data Structures", "Creative Writing", "Databases", "Intro to Computer Science"]

All paths through the curriculum (midpoint *highlighted*):

*Intro to C.S.* -> Graphics
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
*Creative Writing* -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________
                    |          |
                    | Graphics |
               ---->|__________|
               |                          ______________
____________   |                          |            |
|          |   |    ______________     -->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| Logic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|



Sample input 1: (arbitrarily ordered)
  const prereqs_courses1 = [
      ["Foundations of Computer Science", "Operating Systems"],
      ["Data Structures", "Algorithms"],
      ["Computer Networks", "Computer Architecture"],
      ["Algorithms", "Foundations of Computer Science"],
      ["Computer Architecture", "Data Structures"],
      ["Software Design", "Computer Networks"]
  ]

  In this case, the order of the courses in the program is:
      Software Design
      Computer Networks
      Computer Architecture
      Data Structures
      Algorithms
      Foundations of Computer Science
      Operating Systems

  Sample output 1:
      "Data Structures"


  Sample input 2:
  prereqs_courses2 = [
      ["Data Structures", "Algorithms"],
      ["Algorithms", "Foundations of Computer Science"],
      ["Foundations of Computer Science", "Logic"]
  ]


  Sample output 2:
      "Algorithms"
  Sample input 3:
  prereqs_courses3 = [
      ["Data Structures", "Algorithms"],
  ]


  Sample output 3:
      "Data Structures"


Complexity analysis variables:

n: number of pairs in the input

*/

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// TopLogical Sort get the middle one
public class OutputIntermediateCourses {

    public static List<String> findTopologicalSort(List<String[]> preReqCourses) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, ArrayList<String>> graph = new HashMap<>();
        HashSet<String> allCourses = new HashSet<>();
        for (String[] pair : preReqCourses) {
            String preReq  = pair[0];
            String course  = pair[1];
            inDegree.put(course, inDegree.getOrDefault(course, 0) + 1);
            if (!graph.containsKey(preReq)) {
                graph.put(preReq, new ArrayList<>());
            }
            graph.get(preReq).add(course);
            allCourses.add(preReq);
            allCourses.add(course);
        }
        Queue<String> queue = new LinkedList<>();
        // Add all in-degrees == 0 to queue
        for (String course : allCourses) {
            if (!inDegree.containsKey(course)) {
                queue.add(course);
            }
        }

        // Run BFS
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String currentCourse = queue.poll();
            res.add(currentCourse);
            if (graph.containsKey(currentCourse))
                for (String nextCourse : graph.get(currentCourse)) {
                    inDegree.put(nextCourse, inDegree.get(nextCourse) - 1);
                    if (inDegree.get(nextCourse) == 0) {
                        inDegree.remove(nextCourse);
                        queue.add(nextCourse);
                    }
                }
        }
        return res;
    }

    public static String findHalfWayTrough(List<String[]> preReqCourses) {
        List<String> topologicalSort = findTopologicalSort(preReqCourses);

        int halfWay = topologicalSort.size() / 2;

        if (topologicalSort.size() % 2 == 0) {
            return topologicalSort.get(halfWay - 1);
        }
        return topologicalSort.get((int) Math.floor(halfWay));
    }


    public static void main(String[] args) {

        List<String[]> preReqCourses = Arrays.asList(
                new String[]{"Logic", "COBOL"},
                new String[]{"Data Structures", "Algorithms"},
                new String[]{"Creative Writing", "Data Structures"},
                new String[]{"Algorithms", "COBOL"},
                new String[]{"Intro to Computer Science", "Data Structures"},
                new String[]{"Logic", "Compilers"},
                new String[]{"Data Structures", "Logic"},
                new String[]{"Creative Writing", "System Administration"},
                new String[]{"Databases", "System Administration"},
                new String[]{"Creative Writing", "Databases"},
                new String[]{"Intro to Computer Science", "Graphics"}
        );

        System.out.println(findHalfWayTrough(preReqCourses));
    }
}
