Map Content System.

Rational:
  In the Q1 release of Nakamura we had major scalability and concurrency problems caused mainly by our use cases for a content
store not being closely aligned with those of Jackrabbit. We were not able to work arround those problems and although we did manage
to release the code, its quite clear that in certain areas Jackrabbit wont work for us. This should not reflect badly on Jackrabbit, 
but it is a realization that our use cases are not compatable with Jackrabbit when exposed to scale.

This code base is a reaction to that. It aims to be really simple, completely concurrent with no synchronization and designed to scale
linearly with the number of cores and number of servers in a cluster. To do this it borrows some of the concepts from JCR at a very
abstract level, but is making a positive effort and selfish effort to only provide those things that we absolutely need to have. 

This code provides User, Group, Access Control and Content functionality using a sparse Map as a storage abstraction. 

The Implementation works on manipulating sparse objects in the Map with operations like get, insert and delete, but 
has no understanding of the underlying implementation of the storage mechanism. 

At the moment we have 2 storage mechanisms implemented, In Memory using a HashMap, and Cassandra. The approach should 
work on any Column Store (Dynamo, BigTable, Riak, Voldomort, Hbase etc) and can also work on RDBMS's incuding sharded storage.

At the moment there is no query support, expecing all access to be via column IDs, and multiple views to be written to the 
underlying store.

The intention is to provide write through caches based on EhCache or Infinispan.

Transactions are supported, if supported by the underlying implementation of the storage, otherwise all operations are BASIC, non Atomic and immedicate in nature.
We will add search indexes at some point using Lucene, perhapse in the form of Zoie


At this stage its pre-alpha, untested for performance and scalability and incomplete.

