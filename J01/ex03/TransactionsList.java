package ex03;

public interface TransactionsList {
    

    void add( Transaction transaction );
    int remove( Transaction transaction );
    Transaction[] toArray();
    Transaction get( String id );
}
