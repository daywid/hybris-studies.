
hybris Changes
=============================

This is a modified version of Solr.

The following files/directories were removed:
- docs
- example
- dist/test-framework
- dist/solr-test-framework-8.11.2.jar
- server/solr-webapp/webapp/WEB-INF/lib/htrace-core4-4.1.0-incubating.jar

The following files/directories were added:
- HYBRIS_README.txt
- contrib/hybris
- server/solr/security.json.example
- server/solr/solr.p12
- server/solr/solr_client.p12

The following files/directories were modified/replaced:
- bin/solr.cmd:
	- workaround for https://issues.apache.org/jira/browse/SOLR-7283 (lines 19-20)
- bin/solr.in.cmd:
	- authentication and ssl configuration example (lines 217-240)
	- remove UseLargePages parameter from GC_TUNE parameters due to problems with running solr within docker container (line 242)
- bin/solr.in.sh:
	- authentication and ssl configuration example (lines 258-281)
	- remove UseLargePages parameter from GC_TUNE parameters due to problems with running solr within docker container (line 283)
- server/resources/log4j2.xml:
	- change log level for zookeeper to error following changes done as a part of https://issues.apache.org/jira/browse/SOLR-15968 (68-69)
- server/solr/solr.xml
- server/solr/configsets
- guava library (due to https://nvd.nist.gov/vuln/detail/CVE-2020-8908)
    - licenses/guava-25.1-jre.jar.sha1 -> licenses/guava-30.0-jre.jar.sha1
    - server/solr-webapp/webapp/WEB-INF/lib/guava-25.1-jre.jar -> server/solr-webapp/webapp/WEB-INF/lib/guava-30.0-jre.jar
- failureaccess-1.0.1 (due to https://issues.apache.org/jira/browse/SOLR-15090 which will be fixed for solr 9.0.0)
		- added licenses/failureaccess-1.0.1.jar.sha1
		- added licenses/failureaccess-LICENSE-ASL.txt
		- added licenses/licenses/failureaccess-NOTICE.txt
		- added server/solr-webapp/webapp/WEB-INF/lib/failureaccess-1.0.1.jar
- hadoop libraries (due to https://nvd.nist.gov/vuln/detail/CVE-2022-26612)
		- licenses/hadoop-annotations-3.2.2.jar.sha1 -> licenses/hadoop-annotations-3.2.3.jar.sha1
		- server/solr-webapp/webapp/WEB-INF/lib/hadoop-annotations-3.2.2.jar -> server/solr-webapp/webapp/WEB-INF/lib/hadoop-annotations-3.2.3.jar
		- licenses/hadoop-auth-3.2.2.jar.sha1 -> licenses/hadoop-auth-3.2.3.jar.sha1
		- server/solr-webapp/webapp/WEB-INF/lib/hadoop-auth-3.2.2.jar -> server/solr-webapp/webapp/WEB-INF/lib/hadoop-auth-3.2.3.jar
		- licenses/hadoop-common-3.2.2-tests.jar.sha1 -> licenses/hadoop-common-3.2.3-tests.jar.sha1
		- licenses/hadoop-common-3.2.2.jar.sha1 -> licenses/hadoop-common-3.2.3.jar.sha1
		- server/solr-webapp/webapp/WEB-INF/lib/hadoop-common-3.2.2.jar -> server/solr-webapp/webapp/WEB-INF/lib/hadoop-common-3.2.3.jar
		- licenses/hadoop-hdfs-3.2.2-tests.jar.sha1 -> licenses/hadoop-hdfs-3.2.3-tests.jar.sha1
		- licenses/hadoop-hdfs-3.2.2.jar.sha1 -> licenses/hadoop-hdfs-3.2.3.jar.sha1
		- licenses/hadoop-hdfs-client-3.2.2.jar.sha1 -> licenses/hadoop-hdfs-client-3.2.3.jar.sha1
		- server/solr-webapp/webapp/WEB-INF/lib/hadoop-hdfs-client-3.2.2.jar -> server/solr-webapp/webapp/WEB-INF/lib/hadoop-hdfs-client-3.2.3.jar
		- licenses/hadoop-minicluster-3.2.2.jar.sha1 -> licenses/hadoop-minicluster-3.2.3.jar.sha1
		- licenses/hadoop-minikdc-3.2.2.jar.sha1 -> licenses/hadoop-minikdc-3.2.3.jar.sha1
- netty libraries (due to https://nvd.nist.gov/vuln/detail/CVE-2021-43797)
		- licenses/netty-all-4.1.68.Final.jar.sha1 -> licenses/netty-all-4.1.71.Final.jar.sha1
		- licenses/netty-buffer-4.1.68.Final.jar.sha1 -> licenses/netty-buffer-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-buffer-4.1.68.Final.jar -> dist/solrj-lib/netty-buffer-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-buffer-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-buffer-4.1.71.Final.jar
		- licenses/netty-codec-4.1.68.Final.jar.sha1 -> licenses/netty-codec-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-codec-4.1.68.Final.jar -> dist/solrj-lib/netty-codec-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-codec-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-codec-4.1.71.Final.jar
		- licenses/netty-common-4.1.68.Final.jar.sha1 -> licenses/netty-common-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-common-4.1.68.Final.jar -> dist/solrj-lib/netty-common-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-common-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-common-4.1.71.Final.jar
		- licenses/netty-handler-4.1.68.Final.jar.sha1 -> licenses/netty-handler-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-handler-4.1.68.Final.jar -> dist/solrj-lib/netty-handler-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-handler-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-handler-4.1.71.Final.jar
		- licenses/netty-resolver-4.1.68.Final.jar.sha1 -> licenses/netty-resolver-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-resolver-4.1.68.Final.jar -> dist/solrj-lib/netty-resolver-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-resolver-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-resolver-4.1.71.Final.jar
		- licenses/netty-transport-4.1.68.Final.jar.sha1 -> licenses/netty-transport-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-transport-4.1.68.Final.jar -> dist/solrj-lib/netty-transport-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-transport-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-transport-4.1.71.Final.jar
		- licenses/netty-transport-native-epoll-4.1.68.Final.jar.sha1 -> licenses/netty-transport-native-epoll-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-transport-native-epoll-4.1.68.Final.jar -> dist/solrj-lib/netty-transport-native-epoll-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-transport-native-epoll-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-transport-native-epoll-4.1.71.Final.jar
		- licenses/netty-transport-native-unix-common-4.1.68.Final.jar.sha1 -> licenses/netty-transport-native-unix-common-4.1.71.Final.jar.sha1
		- dist/solrj-lib/netty-transport-native-unix-common-4.1.68.Final.jar -> dist/solrj-lib/netty-transport-native-unix-common-4.1.71.Final.jar
		- server/solr-webapp/webapp/WEB-INF/lib/netty-transport-native-unix-common-4.1.68.Final.jar -> server/solr-webapp/webapp/WEB-INF/lib/netty-transport-native-unix-common-4.1.71.Final.jar
- protobuf libraries due to (due to https://nvd.nist.gov/vuln/detail/CVE-2021-22570 and https://nvd.nist.gov/vuln/detail/CVE-2021-22569)
		- licenses/protobuf-java-3.11.0.jar.sha1 -> licenses/protobuf-java-3.19.2.jar.sha1
		- contrib/gcs-repository/lib/protobuf-java-3.11.0.jar -> contrib/gcs-repository/lib/protobuf-java-3.19.2.jar
		- server/solr-webapp/webapp/WEB-INF/lib/protobuf-java-3.11.0.jar -> server/solr-webapp/webapp/WEB-INF/lib/protobuf-java-3.19.2.jar
		- licenses/protobuf-java-util-3.11.0.jar.sha1 -> licenses/protobuf-java-util-3.19.2.jar.sha1
		- contrib/gcs-repository/lib/protobuf-java-util-3.11.0.jar -> contrib/gcs-repository/lib/protobuf-java-util-3.19.2.jar
- zookeeper libraries (due to https://nvd.nist.gov/vuln/detail/CVE-2022-23305, https://nvd.nist.gov/vuln/detail/CVE-2022-23302, https://nvd.nist.gov/vuln/detail/CVE-2021-4104, https://nvd.nist.gov/vuln/detail/CVE-2021-34428 and https://nvd.nist.gov/vuln/detail/CVE-2020-15522)
    - licenses/zookeeper-3.6.2.jar.sha1 -> licenses/zookeeper-3.8.0.jar.sha1
    - licenses/zookeeper-jute-3.6.2.jar.sha1 -> licenses/zookeeper-jute-3.8.0.jar.sha1
    - dist/solrj-lib/zookeeper-3.6.2.jar -> dist/solrj-lib/zookeeper-3.8.0.jar
    - dist/solrj-lib/zookeeper-jute-3.6.2.jar -> dist/solrj-lib/zookeeper-jute-3.8.0.jar
    - server/solr-webapp/webapp/WEB-INF/lib/zookeeper-3.6.2.jar -> server/solr-webapp/webapp/WEB-INF/lib/zookeeper-3.8.0.jar
    - server/solr-webapp/webapp/WEB-INF/lib/zookeeper-jute-3.6.2.jar -> server/solr-webapp/webapp/WEB-INF/lib/zookeeper-jute-3.8.0.jar
