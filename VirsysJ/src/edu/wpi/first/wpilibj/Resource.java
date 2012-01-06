package edu.wpi.first.wpilibj;

/**
 * Track resources in the program.
 * The Resource class is a convenient way of keeping track of allocated arbitrary resources
 * in the program. Resources are just indicies that have an lower and upper bound that are
 * tracked by this class. In the library they are used for tracking allocation of hardware channels
 * but this is purely arbitrary. The resource class does not do any actual allocation, but
 * simply tracks if a given index is currently in use.
 *
 * WARNING: this should only be statically allocated. When the program loads into memory all the
 * static constructors are called. At that time a linked list of all the "Resources" is created.
 * Then when the program actually starts - in the Robot constructor, all resources are initialized.
 * This ensures that the program is restartable in memory without having to unload/reload.
 */
public class Resource {

    /**
     * Allocate storage for a new instance of Resource.
     * Allocate a bool array of values that will get initialized to indicate that no resources
     * have been allocated yet. The indicies of the resources are 0..size-1.
     *
     * @param size The number of blocks to allocate
     */
    public Resource(final int size) {

    }

    /**
     * Allocate a specific resource value.
     * The user requests a specific resource value, i.e. channel number and it is verified
     * unallocated, then returned.
     *
     * @param index The resource to allocate
     * @return The index of the allocated block
     * @throws CheckedAllocationException If there are no resources available to be allocated.
     */
    public int allocate(final int index) throws CheckedAllocationException {
        return index;
    }

    /**
     * Free an allocated resource.
     * After a resource is no longer needed, for example a destructor is called for a channel assignment
     * class, Free will release the resource value so it can be reused somewhere else in the program.
     *
     * @param index The index of the resource to free.
     */
    public void free(final int index) {

    }

    class CheckedAllocationException extends RuntimeException {

    /**
     * Create a new AllocationException
     * @param msg the message to attach to the exception
     */
    public CheckedAllocationException(String msg) {
        super(msg);
    }
}
}