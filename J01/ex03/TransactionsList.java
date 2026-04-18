package ex03;

public interface TransactionsList {
    

    void add( Transaction transaction );

    void remove( Transaction transaction );
    
    Transaction[] toArray();
    
    Transaction get( String id );
}
