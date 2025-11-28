package edu.cmu.Library;

class EmptyBookListException extends Exception {
    public EmptyBookListException(String message) {
        super(message);
    }
}

public class LibraryAccount {
    private LibraryService libraryService;
 
    // BG: Params are complicated (requires formatting of userId)
    // BG: For no books, an empty array is returned instead of null or an exception

    // BG: Violates Quality API design principle (Q3) since
    // BG: client code needs to know the userId format and handle empty arrays.


    /**
     * Retrieves an array of checked out books associated with the specified user ID. If the user
     * has no books checked out, the returned list will be empty. 
     *
     * @param libraryId the ID of the library
     * @param userName the name of the user whose books are to be retrieved
     * @return an array of Book objects the user has checked out
     * @throws EmptyBookListException if the user has no books checked out
     */    
    public Book[] getBooks(String libraryId, String userName) throws EmptyBookListException {

        Book[] books = libraryService.getBooks(libraryId, userName);
        
        if (books.length == 0) {
            throw new EmptyBookListException("No books checked out for user: " + userName);
        }

        return books;
    }
}
