package com.sevval.auth_service.service;

import com.sevval.auth_service.Contracts_UserRegistry_sol_UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import java.math.BigInteger;
import org.web3j.protocol.Web3j;
import org.web3j.utils.Numeric;

@Service
public class BlockchainService {

    private final Web3j web3j;
    private final Credentials credentials;
    private final Contracts_UserRegistry_sol_UserRegistry contract;

    public BlockchainService(@Value("${web3j.client-address}") String rpcUrl,
                             @Value("${blockchain.private-key}") String privateKey,
                             @Value("${blockchain.contract-address}") String contractAddress) throws Exception {

        this.web3j = Web3j.build(new HttpService(rpcUrl));
        this.credentials = Credentials.create(privateKey);

        // Gas ayarları
        BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L); // 20 Gwei
        BigInteger gasLimit = BigInteger.valueOf(3_000_000L);       // 3 milyon

        StaticGasProvider gasProvider = new StaticGasProvider(gasPrice, gasLimit);

        this.contract = Contracts_UserRegistry_sol_UserRegistry.load(
                contractAddress, web3j, credentials, gasProvider
        );
    }

    // Kullanıcıyı blockchain'e kaydet
    public void registerUser(byte[] userHash) throws Exception {
        // Hex string'i byte array'e çevir
        //byte[] userHashBytes = Numeric.hexStringToByteArray(userHash);

        // Wrapper metodunu çağır
        contract.registerUser(userHash).send();
    }

    // Kullanıcıyı blockchain üzerinden doğrula
    public boolean verifyUser(byte[] userHash) throws Exception {
        //byte[] userHashBytes = Numeric.hexStringToByteArray(userHash);
        return contract.verifyUser(userHash).send();
    }
}
