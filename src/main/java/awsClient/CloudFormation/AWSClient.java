package awsClient.CloudFormation;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

public class AWSClient {
    private String key = "";
    private String secret = "";

    public enum eAWSAccount{
        Dev,
        Stage,
        QA,
        Prod
    }

    private void setEnv(eAWSAccount awsAccount){

    }

    public AWSStaticCredentialsProvider connect(eAWSAccount awsConnect){
        setEnv(awsConnect);
        AWSCredentials awsCredentials = new AWSCredentials() {
            @Override
            public String getAWSAccessKeyId() {
                return key;
            }

            @Override
            public String getAWSSecretKey() {
                return secret;
            }
        };
        return new AWSStaticCredentialsProvider(awsCredentials);
    }
}
