package com.sevval.auth_service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.7.0.
 */
@SuppressWarnings("rawtypes")
public class Contracts_UserRegistry_sol_UserRegistry extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061014a806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80632dc032591461003b5780636e67518b14610050575b600080fd5b61004e6100493660046100fb565b610087565b005b61007361005e3660046100fb565b60009081526020819052604090205460ff1690565b604051901515815260200160405180910390f35b60008181526020819052604090205460ff16156100e05760405162461bcd60e51b81526020600482015260136024820152725573657220616c72656164792065786973747360681b604482015260640160405180910390fd5b6000908152602081905260409020805460ff19166001179055565b60006020828403121561010d57600080fd5b503591905056fea26469706673582212202607d5cb7f901e0eb9484d0b3850fb739478aca07cd39cdce6dc877525ac857264736f6c634300080a0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_REGİSTERUSER = "registerUser";

    public static final String FUNC_VERİFYUSER = "verifyUser";

    @Deprecated
    protected Contracts_UserRegistry_sol_UserRegistry(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Contracts_UserRegistry_sol_UserRegistry(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Contracts_UserRegistry_sol_UserRegistry(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Contracts_UserRegistry_sol_UserRegistry(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> registerUser(byte[] userHash) {
        final Function function = new Function(
                FUNC_REGİSTERUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(userHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> verifyUser(byte[] userHash) {
        final Function function = new Function(FUNC_VERİFYUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(userHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static Contracts_UserRegistry_sol_UserRegistry load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contracts_UserRegistry_sol_UserRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Contracts_UserRegistry_sol_UserRegistry load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contracts_UserRegistry_sol_UserRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Contracts_UserRegistry_sol_UserRegistry load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Contracts_UserRegistry_sol_UserRegistry(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Contracts_UserRegistry_sol_UserRegistry load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Contracts_UserRegistry_sol_UserRegistry(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Contracts_UserRegistry_sol_UserRegistry> deploy(Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Contracts_UserRegistry_sol_UserRegistry.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Contracts_UserRegistry_sol_UserRegistry> deploy(Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contracts_UserRegistry_sol_UserRegistry.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<Contracts_UserRegistry_sol_UserRegistry> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Contracts_UserRegistry_sol_UserRegistry.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Contracts_UserRegistry_sol_UserRegistry> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contracts_UserRegistry_sol_UserRegistry.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

//    public static void linkLibraries(List<Contract.LinkReference> references) {
//        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
//    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
