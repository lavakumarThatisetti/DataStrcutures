package Amazon;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
Given a list of [FileName, FileSize, [Collection]] - Collection is optional, i.e., a collection can have 1 or more files. Same file can be a part of more than 1 collection.
How would you design a system

To calculate total size of files processed.
To calculate Top K collections based on size.
Example:
file1.txt(size: 100)
file2.txt(size: 200) in collection "collection1"
file3.txt(size: 200) in collection "collection1"
file4.txt(size: 300) in collection "collection2"
file5.txt(size: 100)
Output:

Total size of files processed: 900
Top 2 collections:

collection1 : 400
collection2 : 300
 */
public class FileProcessingTopK {

    static class ListProcess {
        String FileName;
        int fileSize;
        List<String> collection;

        public ListProcess(String fileName, int fileSize, List<String> collection) {
            FileName = fileName;
            this.fileSize = fileSize;
            this.collection = collection;
        }
    }

    int totalSizeofFilesProcessed;
    HashMap<String, Integer> topKCollections;

    FileProcessingTopK(){
        this.totalSizeofFilesProcessed = 0;
        topKCollections = new HashMap<>();
    }


    public void fileProcessing(List<ListProcess> lists, int topK){


        for(ListProcess listProcess : lists){
            totalSizeofFilesProcessed += listProcess.fileSize;
            for (String s : listProcess.collection) {
               topKCollections.put(s, topKCollections.getOrDefault(s,0)+listProcess.fileSize);
            }
        }

        System.out.println("Total Process Files Size "+totalSizeofFilesProcessed);
        PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        for(Map.Entry<String,Integer> map: topKCollections.entrySet()){
            pq.add(new Pair<>(map.getKey(), map.getValue()));
        }

        List<Pair<String,Integer>> res = new ArrayList<>();
        while(!pq.isEmpty() && --topK>=0){
            res.add(pq.poll());
        }

        System.out.println(res);
    }

    public static void main(String[] args) {

        FileProcessingTopK fileProcessingTopK = new FileProcessingTopK();

        List<ListProcess> lists = new ArrayList<>();
        lists.add(new ListProcess("File1",100, new ArrayList<>()));
        lists.add(new ListProcess("File2",200, new ArrayList<>(Arrays.asList("Collection 1"))));
        lists.add(new ListProcess("File3",200, new ArrayList<>(Arrays.asList("Collection 2"))));
        lists.add(new ListProcess("File4",300, new ArrayList<>(Arrays.asList("Collection 2"))));
        lists.add(new ListProcess("File5",100, new ArrayList<>()));

        fileProcessingTopK.fileProcessing(lists,2);
    }
}
