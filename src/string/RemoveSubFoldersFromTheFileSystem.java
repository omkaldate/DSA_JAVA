package string;

import java.util.*;

public class RemoveSubFoldersFromTheFileSystem {
         public List<String> removeSubfolders(String[] folder) {
         Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
         List<String> result = new ArrayList<>();

         for (String currFolder : folder) {
             boolean isSubFolder = false;
             String tempFolder = currFolder;

             while (!currFolder.isEmpty()) {
                 int position = currFolder.lastIndexOf('/');
                 if (position == -1) break;

                 currFolder = currFolder.substring(0, position);

                 if (folderSet.contains(currFolder)) {
                     isSubFolder = true;
                     break;
                 }
             }
             if (!isSubFolder) {
                 result.add(tempFolder);
             }
         }
         return result;
     }



    public List<String> removeSubfolder(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();

        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String currFolder = folder[i];
            String lastFolder = result.get(result.size() - 1);
            lastFolder += "/";

            if (!currFolder.startsWith(lastFolder)) {
                result.add(currFolder);
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
