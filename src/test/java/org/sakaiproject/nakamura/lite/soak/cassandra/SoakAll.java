package org.sakaiproject.nakamura.lite.soak.cassandra;

import org.sakaiproject.nakamura.api.lite.ConnectionPoolException;
import org.sakaiproject.nakamura.api.lite.StorageClientException;
import org.sakaiproject.nakamura.api.lite.accesscontrol.AccessDeniedException;

public class SoakAll {

    public static void main(String[] argv) throws ConnectionPoolException, StorageClientException, AccessDeniedException, ClassNotFoundException {
        CreateUsersAndGroupsSoak.main(argv);
        CreateUsersAndGroupsWithMembersSoak.main(argv);
    }
}