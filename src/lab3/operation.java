package lab3;
import java.util.ArrayList;

/**
 * @author Danil Orlov
 **/
public class operation {
    protected ArrayList<ArrayList<Integer>> mtx;
    protected ArrayList<ArrayList<Integer>> mtx_weight;
    /**
     * Constructor(return class)
     * @param _mx ArrayList<ArrayList<Integer>>
     * @param _size int
     **/
    public operation(ArrayList<ArrayList<Integer>> _mx, int _size)
    {
        this.mtx = new ArrayList<>(_size);
        for (int i = 0;i < _size;i++)
            this.mtx.add(i,_mx.get(i));

    }
    /**
     * Constructor for weight(return class)
     * @param _mx ArrayList<ArrayList<Integer>>
     **/
    public operation(ArrayList<ArrayList<Integer>> _mx)
    {
        this.mtx_weight = new ArrayList<>(_mx.size());
        for (int i = 0;i < _mx.size();i++)
            this.mtx_weight.add(i,_mx.get(i));

    }
    /** Returns array weight ribs
     * @param mx ArrayList<Integer>
     * @param j int
     * @return array
     **/
    public ArrayList<ArrayList<Integer>> infoMatrixWeight(ArrayList<Integer> mx,int j) {
        ArrayList<Integer> fillerMassive1;
        ArrayList<ArrayList<Integer>> fillerMatrix1 = new ArrayList<>(mx.size());
        for (int i = 0; i < mx.size(); i++) {
            fillerMassive1 = new ArrayList<>(3);
            fillerMassive1.add(0, j+1);
            fillerMassive1.add(1, mx.get(i));
            fillerMassive1.add(2, this.mtx_weight.get(j).get(mx.get(i)-1));
            fillerMatrix1.add(i, fillerMassive1);
        }
        return fillerMatrix1;
    }
    /**  Returns array of neighboring peaks in adjacency matrix
     * @param j int
     * @return array
     * @throws IllegalArgumentException if matrix have different size
     **/
    public  ArrayList<Integer> infoMatrix(int j) throws IllegalArgumentException{
        if (j<this.mtx.size() && j > -1) {
            int col = 0;
            for (int i = 0; i < this.mtx.size(); i++) {
                if (this.mtx.get(j).get(i) == 1)
                    col++;
            }
            ArrayList<Integer> Answer = new ArrayList<>(col);
            col = 0;
            for (int i = 0; i < this.mtx.size(); i++) {
                if (this.mtx.get(j).get(i) == 1) {
                    Answer.add(col, i + 1);
                    col++;
                }

            }
            return Answer;
        }   else  throw new IllegalArgumentException("Такой вершины не существует");
    }
    /** Returns array of neighboring peaks
     * @param j int
     * @return array
     * @throws IllegalArgumentException if matrix have different size
     **/
    public  ArrayList<Integer> infoMatrixSR(int j) {
        if (j<this.mtx.size()+1 && j > 0) {
            int col = 0;
            for (ArrayList<Integer> integers : this.mtx) {
                if (integers.get(0) == j)
                    col++;
            }
            ArrayList<Integer> Answer = new ArrayList<>(col);
            col = 0;
            for (ArrayList<Integer> integers : this.mtx) {
                if (integers.get(0) == j) {
                    Answer.add(col, integers.get(1));
                    col++;
                }

            }
            return Answer;
        }   else  throw new IllegalArgumentException("Такой вершины не существует");
    }
    /** removes merge vertices in adjacency matrix
     * @param j int
     * @param i int
     * @throws IllegalArgumentException if this link does not exist
     **/
    public  void Del(int j, int i) {
        if (this.mtx.get(j).get(i)==1) this.mtx.get(j).set(i , 0);
        else  throw new IllegalArgumentException("Данная связь не существует");

    }
    /** adds connection between vertices in adjacency matrix
     * @param j int
     * @param i int
     * @throws IllegalArgumentException if this exist
     **/
    public  void Add(int j, int i) {
        if (this.mtx.get(j).get(i)==0) this.mtx.get(j).set(i , 1);
        else  throw new IllegalArgumentException("Данная связь уже существует");
    }

    public  void AddWeight(int j, int i, int num) {
        this.mtx_weight.get(j).set(i,num);
    }
    /** adds connection between vertices in list of ribs
     * @param j1 int
     * @param i1 int
     * @throws IllegalArgumentException if this exist
     **/
    public  ArrayList<ArrayList<Integer>> AddSR(int j1, int i1) {
        boolean error = false;
        for (ArrayList<Integer> integers : this.mtx) {
            if (integers.get(0) == j1 && integers.get(1) == i1) {
                error = true;
                break;
            }
        }

        if (!error) {
            ArrayList<Integer> fillerMassive1;
            ArrayList<ArrayList<Integer>> fillerMatrix1 = new ArrayList<>(this.mtx.size()+1);
            for (int i = 0; i < this.mtx.size(); i++) {
                fillerMatrix1.add(i,this.mtx.get(i));
            }
            fillerMassive1 = new ArrayList<>(2);
            fillerMassive1.add(0, j1);
            fillerMassive1.add(1, i1);
            fillerMatrix1.add(this.mtx.size(), fillerMassive1);
            return (fillerMatrix1);
        }else  throw new IllegalArgumentException("Данная связь уже существует");
    }
    /** removes merge vertices in list of ribs
     * @param j1 int
     * @param i1 int
     * @throws IllegalArgumentException if this link does not exist
     **/
    public  ArrayList<ArrayList<Integer>> DelSR(int j1, int i1) {
        ArrayList<ArrayList<Integer>> fillerMatrix1 = new ArrayList<>(this.mtx.size()+1);
        int minus = 0;
        for (int i = 0; i < this.mtx.size(); i++) {
            if (this.mtx.get(i).get(0)==j1 && this.mtx.get(i).get(1)==i1 )
            {
                minus = 1;
            }
            else
                fillerMatrix1.add(i - minus,this.mtx.get(i));
        }
        if (minus==1)
            return (fillerMatrix1);
        else  throw new IllegalArgumentException("Данная связь не существует");

    }
    /** Returns array of neighboring peaks in vertex adjacency list
     * @param j int
     * @return array
     * @throws IllegalArgumentException if matrix have different size
     **/
    public  ArrayList<Integer> infoMatrixSSR(int j) {
        if (j<this.mtx.size() && j > -1) return this.mtx.get(j);
        else
            throw new IllegalArgumentException("Такой вершины не существует");
    }
    /** adds connection between vertices in vertex adjacency list
     * @param j1 int
     * @param i1 int
     * @throws IllegalArgumentException if this exist
     **/
    public  ArrayList<ArrayList<Integer>> AddSSR(int j1, int i1) {
        boolean error = false;
        for (int j = 0; j < this.mtx.get(j1).size(); j++) {
            if (this.mtx.get(j1).get(j) == i1) {
                error = true;
                break;
            }
        }
        if (!error) {
            ArrayList<Integer> fillerMassive1;
            ArrayList<ArrayList<Integer>> fillerMatrix1 = new ArrayList<>(this.mtx.size() + 1);
            for (int i = 0; i < this.mtx.size(); i++) {
                if (i == j1) {
                    fillerMassive1 = new ArrayList<>(this.mtx.get(j1).size() + 1);
                    for (int j = 0; j < this.mtx.get(j1).size(); j++) {
                        fillerMassive1.add(j, this.mtx.get(j1).get(j));
                    }
                    fillerMassive1.add(this.mtx.get(j1).size(), i1);
                    fillerMatrix1.add(j1, fillerMassive1);
                } else
                    fillerMatrix1.add(i, this.mtx.get(i));
            }
            return (fillerMatrix1);
        }else  throw new IllegalArgumentException("Данная связь уже существует");
    }
    /** removes merge vertices in vertex adjacency list
     * @param j1 int
     * @param i1 int
     * @throws IllegalArgumentException if this link does not exist
     **/
    public  ArrayList<ArrayList<Integer>> DelSSR(int j1, int i1) {
        ArrayList<Integer> fillerMassive1;
        ArrayList<ArrayList<Integer>> fillerMatrix1 = new ArrayList<>(this.mtx.size()+1);
        boolean error = true;
        for (int i = 0; i < this.mtx.size(); i++) {

                if (i == j1) {
                    if (this.mtx.get(i).size()!=0)
                    fillerMassive1 = new ArrayList<>(this.mtx.get(i).size() - 1);
                    else {fillerMassive1 = new ArrayList<>(this.mtx.get(i).size());
                    break;
                    };
                }
                else fillerMassive1 = new ArrayList<>(this.mtx.get(i).size());
                int minus = 0;
                for (int j = 0; j < this.mtx.get(i).size(); j++) {
                    if (this.mtx.get(i).get(j) == i1 && i == j1) {
                        error = false;
                        minus = 1;
                    } else
                        fillerMassive1.add(j - minus, this.mtx.get(i).get(j));
                }
                fillerMatrix1.add(i, fillerMassive1);

        }
        if (!error)
            return (fillerMatrix1);
        else  throw new IllegalArgumentException("Данная связь не существует");
    }
    /** return matrix size
     * @return array
     **/
    public int size(){
        return this.mtx.size();
    }
    public ArrayList<ArrayList<Integer>> mas(){
        return this.mtx;
    }
}
