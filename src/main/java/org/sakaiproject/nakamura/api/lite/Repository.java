package org.sakaiproject.nakamura.api.lite;

import org.sakaiproject.nakamura.api.lite.accesscontrol.AccessDeniedException;

public interface Repository {

    Session login(String username, String password) throws ConnectionPoolException,
            StorageClientException, AccessDeniedException;

    Session login() throws ConnectionPoolException, StorageClientException, AccessDeniedException;

    Session loginAdministrative() throws ConnectionPoolException, StorageClientException,
            AccessDeniedException;

    Session loginAdministrative(String username) throws ConnectionPoolException, StorageClientException, AccessDeniedException;

}