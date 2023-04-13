package awsClient.CloudFormation;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.*;
import com.amazonaws.util.CollectionUtils;
import org.awaitility.Awaitility;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CloudformationUtils {

    private static final List<String> CAPABILITIES = Collections.singletonList("CAPABILITY_NAMED_IAM");

    public static void createStack(AmazonCloudFormation client, String stackName) {
        CreateStackRequest createStackRequest = new CreateStackRequest()
                .withStackName(stackName)
                .withTemplateBody("")
                .withCapabilities(CAPABILITIES);
        client.createStack(createStackRequest);

        StackStatus status = (StackStatus)  Awaitility.await("Wait for Stack to be created...")
                .atMost(600, TimeUnit.SECONDS)
                .pollInterval(2, TimeUnit.SECONDS)
                .until(getStackStatus(client,stackName),(t)->{
                    return !isStackInProgress(t);
        });

    }

    private static boolean isStackInProgress(StackStatus stackStatus) {
        return stackStatus == StackStatus.CREATE_IN_PROGRESS || stackStatus == StackStatus.UPDATE_IN_PROGRESS || stackStatus == StackStatus.UPDATE_COMPLETE_CLEANUP_IN_PROGRESS || stackStatus == StackStatus.ROLLBACK_IN_PROGRESS || stackStatus == StackStatus.ROLLBACK_COMPLETE;
    }



    private static Callable<StackStatus> getStackStatus(AmazonCloudFormation client, String stackName){
        return ()->{
            return stackStatus(client,stackName);
        };
    }

    private static StackStatus stackStatus(AmazonCloudFormation client, String stackName) {
        DescribeStacksRequest describeStacksRequest = new DescribeStacksRequest();
        describeStacksRequest.setStackName(stackName);
        try{
            List<Stack> stacks = client.describeStacks(describeStacksRequest).getStacks();
            if(CollectionUtils.isNullOrEmpty(stacks)){
                throw new IndexOutOfBoundsException("new exception");
            }
            return StackStatus.fromValue(stacks.get(0).getStackStatus());
        }catch(AmazonServiceException ase){
            return null;
        }
    }

}
