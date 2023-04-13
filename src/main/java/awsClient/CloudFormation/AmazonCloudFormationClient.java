package awsClient.CloudFormation;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;

public class AmazonCloudFormationClient extends AWSClient {

  private AWSClient.eAWSAccount awsAccount;
  private Regions regions;

    public AmazonCloudFormationClient(eAWSAccount awsAccount, Regions regions) {
        this.awsAccount = awsAccount;
        this.regions = regions;
    }


    public AmazonCloudFormation cloudFormationClientBuild(){
        AWSStaticCredentialsProvider credentialsProvider = connect(this.awsAccount);
        return AmazonCloudFormationClientBuilder
                .standard()
                .withCredentials(credentialsProvider)
                .withRegion(this.regions)
                .build();
    }
}
