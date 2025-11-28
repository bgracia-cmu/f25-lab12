package edu.cmu.DirManager;

// BG: Violates Usability API design principle (U1, U3)
// BG: since it uses error codes instead of exceptions to indicate failure conditions.
// BG: The fix is to replace error codes with exceptions for better clarity and usability.

class DirectoryExistsException extends Exception {
    public DirectoryExistsException(String message) {
        super(message);
    }
}

class InvalidPathException extends Exception {
    public InvalidPathException(String message) {
        super(message);
    }
}

public class Manager {
    private DirOps dirOps;
    
    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @return 0 if the directory creation was successful
     *        -1 if the directory already exists,
     *        -2 if the path is invalid
     */
    public void newDirectory(String path) throws DirectoryExistsException, InvalidPathException {
        if (dirOps.checkDirectoryExists(path)) {
            throw new DirectoryExistsException("Directory already exists at path: " + path);
        } else if (!dirOps.checkPathValid(path)) {
            throw new InvalidPathException("Invalid path: " + path);
        }

        dirOps.createDirectory(path);
    }
}
