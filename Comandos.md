EN EL SERVIDOR:

keytool -genkey -alias servidor  -keyalg RSA -keystore AlmacenSrv -storepass 1234567

keytool -exportcert -alias servidor  -keystore AlmacenSrv -storepass 1234567 -file CertificadoServ.cer

 
--------------------
EN EL CLIENTE:

keytool -importcert -trustcacerts -alias servidor -file CertificadoServ.cer -keystore CliCertConfianza -storepass 890123

keytool -genkey -alias cliente -keyalg RSA -keystore AlmacenCli -storepass clavecli

keytool -exportcert -alias cliente -keystore AlmacenCli -storepass clavecli -file CertificadoCli.cer

EN EL SERVIDOR:

keytool -importcert -trustcacerts -alias cercliente -file CertificadoCli.cer -keystore SrvCertConfianza -storepass cercli