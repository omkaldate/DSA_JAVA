package Graph;

import java.util.*;

public class AccountsMerge {

    static class Disjoint_UnionRank {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        Disjoint_UnionRank(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node)) return node;

            int save = findParent(parent.get(node));
            parent.set(node, save);
            return save;
        }

        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv)
                return;
            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, pv);
            } else if (rank.get(pu) > rank.get(pv)) {
                parent.set(pv, pu);
            } else {
                parent.set(pv, pu);
                int rank_u = rank.get(pu);
                rank.set(pu, rank_u + 1);
            }
        }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint_UnionRank ds = new Disjoint_UnionRank(n);

        HashMap<String,Integer> mpp = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(! mpp.containsKey(mail)){
                    mpp.put(mail,i);
                }
                else{
                    ds.union(mpp.get(mail) , i);
                }
            }
        }

        ArrayList<String> []mapMail = new ArrayList[n];
        for(int i=0; i<n; i++){
            mapMail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String,Integer> it: mpp.entrySet()){
            String mail = it.getKey();
            int node = ds.findParent(it.getValue());
            mapMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(mapMail[i].size() == 0) continue;

            Collections.sort(mapMail[i]);
            List<String> ls = new ArrayList<>();
            ls.add(accounts.get(i).get(0));

            for(String x: mapMail[i]){
                ls.add(x);
            }
            ans.add(ls);
        }
        return ans;
    }


    public static void main(String[] args) {
        AccountsMerge am = new AccountsMerge();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> mergedAccounts = am.accountsMerge(accounts);

        for (List<String> account : mergedAccounts) {
            System.out.println(account);
        }
    }
}
