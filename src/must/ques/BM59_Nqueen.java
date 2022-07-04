package must.ques;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName BM59_Nqueen
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/2 18:02
 * @Version 1.0
 **/
public class BM59_Nqueen {
    public static void main(String[] args) {
        BM59_Nqueen solu = new BM59_Nqueen();
        System.out.println(solu.Nqueen(8));
    }

    //private static int counter =0;
    public int Nqueen (int n) {
        List<Pos> pool  = new ArrayList<>();
        Integer counter = new Integer(0);
        backtrack(counter,n,pool,1);
        return counter;
    }

    private void backtrack (Integer counter,int n,List<Pos>pool,int currRow) {
        if (currRow==n+1) {
            counter=counter+1;
            return;
        }
        for (int c = 1; c <=n ; c++) {
            if (!valid(pool,new Pos(currRow,c))) {
                continue;
            }
            pool.add(new Pos(currRow,c));
            backtrack(counter,n,pool,currRow+1);
            pool.remove(pool.size()-1);
        }
    }

    private boolean valid(List<Pos>pool,Pos currPos) {
        for (Pos pos : pool) {
            if (pos.r==currPos.r || pos.c==currPos.c ||
            currPos.c- currPos.r==pos.c- pos.r ||
            currPos.c+ currPos.r== pos.c+ pos.r) {
                return false;
            }
        }
        return true;
    }

    class Pos {
        public int r;
        public int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return r == pos.r && c == pos.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
