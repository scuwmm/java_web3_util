package org.web3j.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Array;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.4.
 */
@SuppressWarnings("rawtypes")
public class TransitSwapRouterV4 extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_ACCEPTEXECUTORSHIP = "acceptExecutorship";

    public static final String FUNC_ACCEPTOWNERSHIP = "acceptOwnership";

    public static final String FUNC_CHANGEPAUSE = "changePause";

    public static final String FUNC_CHANGESWAPTYPEMODE = "changeSwapTypeMode";

    public static final String FUNC_CHANGETRANSITCROSS = "changeTransitCross";

    public static final String FUNC_CHANGETRANSITFEES = "changeTransitFees";

    public static final String FUNC_CHANGETRANSITSWAP = "changeTransitSwap";

    public static final String FUNC_CHANGEWRAPPEDALLOWED = "changeWrappedAllowed";

    public static final String FUNC_CROSS = "cross";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SWAP = "swap";

    public static final String FUNC_TRANSFEREXECUTORSHIP = "transferExecutorship";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_WITHDRAWTOKENS = "withdrawTokens";

    public static final String FUNC_EXECUTOR = "executor";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_PENDINGEXECUTOR = "pendingExecutor";

    public static final String FUNC_PENDINGOWNER = "pendingOwner";

    public static final String FUNC_SWAPTYPEMODE = "swapTypeMode";

    public static final String FUNC_TRANSITCROSS = "transitCross";

    public static final String FUNC_TRANSITFEES = "transitFees";

    public static final String FUNC_TRANSITSWAP = "transitSwap";

    public static final String FUNC_WRAPPEDALLOWED = "wrappedAllowed";

    public static final Event CHANGESWAPTYPEMODE_EVENT = new Event("ChangeSwapTypeMode", 
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<DynamicArray<Bool>>() {}));
    ;

    public static final Event CHANGETRANSITCROSS_EVENT = new Event("ChangeTransitCross", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event CHANGETRANSITFEES_EVENT = new Event("ChangeTransitFees", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event CHANGETRANSITSWAP_EVENT = new Event("ChangeTransitSwap", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event CHANGEWRAPPEDALLOWED_EVENT = new Event("ChangeWrappedAllowed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<Bool>>() {}));
    ;

    public static final Event EXECUTORSHIPTRANSFERSTARTED_EVENT = new Event("ExecutorshipTransferStarted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event EXECUTORSHIPTRANSFERRED_EVENT = new Event("ExecutorshipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERSTARTED_EVENT = new Event("OwnershipTransferStarted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PAUSED_EVENT = new Event("Paused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event RECEIPT_EVENT = new Event("Receipt", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSITSOURCE_EVENT = new Event("TransitSource", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event TRANSITSWAPPED_EVENT = new Event("TransitSwapped", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event WITHDRAW_EVENT = new Event("Withdraw", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected TransitSwapRouterV4(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransitSwapRouterV4(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TransitSwapRouterV4(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TransitSwapRouterV4(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptExecutorship() {
        final Function function = new Function(
                FUNC_ACCEPTEXECUTORSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptOwnership() {
        final Function function = new Function(
                FUNC_ACCEPTOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> changePause(Boolean paused) {
        final Function function = new Function(
                FUNC_CHANGEPAUSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(paused)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> changeSwapTypeMode(List<BigInteger> swapTypes) {
        final Function function = new Function(
                FUNC_CHANGESWAPTYPEMODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint8>(
                        org.web3j.abi.datatypes.generated.Uint8.class,
                        org.web3j.abi.Utils.typeMap(swapTypes, org.web3j.abi.datatypes.generated.Uint8.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<ChangeSwapTypeModeEventResponse> getChangeSwapTypeModeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CHANGESWAPTYPEMODE_EVENT, transactionReceipt);
        ArrayList<ChangeSwapTypeModeEventResponse> responses = new ArrayList<ChangeSwapTypeModeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangeSwapTypeModeEventResponse typedResponse = new ChangeSwapTypeModeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.types = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(0)).getNativeValueCopy();
            typedResponse.newModes = (List<Boolean>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChangeSwapTypeModeEventResponse> changeSwapTypeModeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ChangeSwapTypeModeEventResponse>() {
            @Override
            public ChangeSwapTypeModeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGESWAPTYPEMODE_EVENT, log);
                ChangeSwapTypeModeEventResponse typedResponse = new ChangeSwapTypeModeEventResponse();
                typedResponse.log = log;
                typedResponse.types = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(0)).getNativeValueCopy();
                typedResponse.newModes = (List<Boolean>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
                return typedResponse;
            }
        });
    }

    public Flowable<ChangeSwapTypeModeEventResponse> changeSwapTypeModeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGESWAPTYPEMODE_EVENT));
        return changeSwapTypeModeEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> changeTransitCross(String newTransit) {
        final Function function = new Function(
                FUNC_CHANGETRANSITCROSS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newTransit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<ChangeTransitCrossEventResponse> getChangeTransitCrossEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CHANGETRANSITCROSS_EVENT, transactionReceipt);
        ArrayList<ChangeTransitCrossEventResponse> responses = new ArrayList<ChangeTransitCrossEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangeTransitCrossEventResponse typedResponse = new ChangeTransitCrossEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousTransit = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newTransit = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChangeTransitCrossEventResponse> changeTransitCrossEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ChangeTransitCrossEventResponse>() {
            @Override
            public ChangeTransitCrossEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGETRANSITCROSS_EVENT, log);
                ChangeTransitCrossEventResponse typedResponse = new ChangeTransitCrossEventResponse();
                typedResponse.log = log;
                typedResponse.previousTransit = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newTransit = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChangeTransitCrossEventResponse> changeTransitCrossEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGETRANSITCROSS_EVENT));
        return changeTransitCrossEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> changeTransitFees(String newTransitFees) {
        final Function function = new Function(
                FUNC_CHANGETRANSITFEES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newTransitFees)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<ChangeTransitFeesEventResponse> getChangeTransitFeesEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CHANGETRANSITFEES_EVENT, transactionReceipt);
        ArrayList<ChangeTransitFeesEventResponse> responses = new ArrayList<ChangeTransitFeesEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangeTransitFeesEventResponse typedResponse = new ChangeTransitFeesEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousTransitFees = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newTransitFees = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChangeTransitFeesEventResponse> changeTransitFeesEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ChangeTransitFeesEventResponse>() {
            @Override
            public ChangeTransitFeesEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGETRANSITFEES_EVENT, log);
                ChangeTransitFeesEventResponse typedResponse = new ChangeTransitFeesEventResponse();
                typedResponse.log = log;
                typedResponse.previousTransitFees = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newTransitFees = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChangeTransitFeesEventResponse> changeTransitFeesEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGETRANSITFEES_EVENT));
        return changeTransitFeesEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> changeTransitSwap(String newTransit) {
        final Function function = new Function(
                FUNC_CHANGETRANSITSWAP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newTransit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<ChangeTransitSwapEventResponse> getChangeTransitSwapEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CHANGETRANSITSWAP_EVENT, transactionReceipt);
        ArrayList<ChangeTransitSwapEventResponse> responses = new ArrayList<ChangeTransitSwapEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangeTransitSwapEventResponse typedResponse = new ChangeTransitSwapEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousTransit = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newTransit = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChangeTransitSwapEventResponse> changeTransitSwapEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ChangeTransitSwapEventResponse>() {
            @Override
            public ChangeTransitSwapEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGETRANSITSWAP_EVENT, log);
                ChangeTransitSwapEventResponse typedResponse = new ChangeTransitSwapEventResponse();
                typedResponse.log = log;
                typedResponse.previousTransit = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newTransit = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChangeTransitSwapEventResponse> changeTransitSwapEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGETRANSITSWAP_EVENT));
        return changeTransitSwapEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> changeWrappedAllowed(List<String> wrappeds) {
        final Function function = new Function(
                FUNC_CHANGEWRAPPEDALLOWED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(wrappeds, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<ChangeWrappedAllowedEventResponse> getChangeWrappedAllowedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CHANGEWRAPPEDALLOWED_EVENT, transactionReceipt);
        ArrayList<ChangeWrappedAllowedEventResponse> responses = new ArrayList<ChangeWrappedAllowedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangeWrappedAllowedEventResponse typedResponse = new ChangeWrappedAllowedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.wrappeds = (List<String>) ((Array) eventValues.getNonIndexedValues().get(0)).getNativeValueCopy();
            typedResponse.newAllowed = (List<Boolean>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChangeWrappedAllowedEventResponse> changeWrappedAllowedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ChangeWrappedAllowedEventResponse>() {
            @Override
            public ChangeWrappedAllowedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGEWRAPPEDALLOWED_EVENT, log);
                ChangeWrappedAllowedEventResponse typedResponse = new ChangeWrappedAllowedEventResponse();
                typedResponse.log = log;
                typedResponse.wrappeds = (List<String>) ((Array) eventValues.getNonIndexedValues().get(0)).getNativeValueCopy();
                typedResponse.newAllowed = (List<Boolean>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
                return typedResponse;
            }
        });
    }

    public Flowable<ChangeWrappedAllowedEventResponse> changeWrappedAllowedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGEWRAPPEDALLOWED_EVENT));
        return changeWrappedAllowedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> cross(TransitSwapDescription desc, CallbytesDescription callbytesDesc, String source, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CROSS, 
                Arrays.<Type>asList(desc, 
                callbytesDesc, 
                new org.web3j.abi.datatypes.Utf8String(source)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public static List<ExecutorshipTransferStartedEventResponse> getExecutorshipTransferStartedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EXECUTORSHIPTRANSFERSTARTED_EVENT, transactionReceipt);
        ArrayList<ExecutorshipTransferStartedEventResponse> responses = new ArrayList<ExecutorshipTransferStartedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecutorshipTransferStartedEventResponse typedResponse = new ExecutorshipTransferStartedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousExecutor = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newExecutor = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutorshipTransferStartedEventResponse> executorshipTransferStartedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ExecutorshipTransferStartedEventResponse>() {
            @Override
            public ExecutorshipTransferStartedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTORSHIPTRANSFERSTARTED_EVENT, log);
                ExecutorshipTransferStartedEventResponse typedResponse = new ExecutorshipTransferStartedEventResponse();
                typedResponse.log = log;
                typedResponse.previousExecutor = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newExecutor = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutorshipTransferStartedEventResponse> executorshipTransferStartedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTORSHIPTRANSFERSTARTED_EVENT));
        return executorshipTransferStartedEventFlowable(filter);
    }

    public static List<ExecutorshipTransferredEventResponse> getExecutorshipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EXECUTORSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<ExecutorshipTransferredEventResponse> responses = new ArrayList<ExecutorshipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecutorshipTransferredEventResponse typedResponse = new ExecutorshipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousExecutor = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newExecutor = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutorshipTransferredEventResponse> executorshipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ExecutorshipTransferredEventResponse>() {
            @Override
            public ExecutorshipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTORSHIPTRANSFERRED_EVENT, log);
                ExecutorshipTransferredEventResponse typedResponse = new ExecutorshipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousExecutor = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newExecutor = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutorshipTransferredEventResponse> executorshipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTORSHIPTRANSFERRED_EVENT));
        return executorshipTransferredEventFlowable(filter);
    }

    public static List<OwnershipTransferStartedEventResponse> getOwnershipTransferStartedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERSTARTED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferStartedEventResponse> responses = new ArrayList<OwnershipTransferStartedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferStartedEventResponse typedResponse = new OwnershipTransferStartedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferStartedEventResponse> ownershipTransferStartedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferStartedEventResponse>() {
            @Override
            public OwnershipTransferStartedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERSTARTED_EVENT, log);
                OwnershipTransferStartedEventResponse typedResponse = new OwnershipTransferStartedEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferStartedEventResponse> ownershipTransferStartedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERSTARTED_EVENT));
        return ownershipTransferStartedEventFlowable(filter);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public static List<PausedEventResponse> getPausedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PAUSED_EVENT, transactionReceipt);
        ArrayList<PausedEventResponse> responses = new ArrayList<PausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PausedEventResponse typedResponse = new PausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PausedEventResponse>() {
            @Override
            public PausedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAUSED_EVENT, log);
                PausedEventResponse typedResponse = new PausedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAUSED_EVENT));
        return pausedEventFlowable(filter);
    }

    public static List<ReceiptEventResponse> getReceiptEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(RECEIPT_EVENT, transactionReceipt);
        ArrayList<ReceiptEventResponse> responses = new ArrayList<ReceiptEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceiptEventResponse typedResponse = new ReceiptEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceiptEventResponse> receiptEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReceiptEventResponse>() {
            @Override
            public ReceiptEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIPT_EVENT, log);
                ReceiptEventResponse typedResponse = new ReceiptEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceiptEventResponse> receiptEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIPT_EVENT));
        return receiptEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> swap(TransitSwapDescription desc, CallbytesDescription callbytesDesc, String source, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SWAP, 
                Arrays.<Type>asList(desc, 
                callbytesDesc, 
                new org.web3j.abi.datatypes.Utf8String(source)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> transferExecutorship(String newExecutor) {
        final Function function = new Function(
                FUNC_TRANSFEREXECUTORSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newExecutor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<TransitSourceEventResponse> getTransitSourceEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSITSOURCE_EVENT, transactionReceipt);
        ArrayList<TransitSourceEventResponse> responses = new ArrayList<TransitSourceEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransitSourceEventResponse typedResponse = new TransitSourceEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.source = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransitSourceEventResponse> transitSourceEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransitSourceEventResponse>() {
            @Override
            public TransitSourceEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSITSOURCE_EVENT, log);
                TransitSourceEventResponse typedResponse = new TransitSourceEventResponse();
                typedResponse.log = log;
                typedResponse.source = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransitSourceEventResponse> transitSourceEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSITSOURCE_EVENT));
        return transitSourceEventFlowable(filter);
    }

    public static List<TransitSwappedEventResponse> getTransitSwappedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSITSWAPPED_EVENT, transactionReceipt);
        ArrayList<TransitSwappedEventResponse> responses = new ArrayList<TransitSwappedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransitSwappedEventResponse typedResponse = new TransitSwappedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.srcToken = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.dstToken = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.dstReceiver = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.trader = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.feeMode = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.returnAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.minReturnAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.fee = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.toChainID = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.channel = (String) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransitSwappedEventResponse> transitSwappedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransitSwappedEventResponse>() {
            @Override
            public TransitSwappedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSITSWAPPED_EVENT, log);
                TransitSwappedEventResponse typedResponse = new TransitSwappedEventResponse();
                typedResponse.log = log;
                typedResponse.srcToken = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.dstToken = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.dstReceiver = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.trader = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.feeMode = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.returnAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.minReturnAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.fee = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.toChainID = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.channel = (String) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransitSwappedEventResponse> transitSwappedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSITSWAPPED_EVENT));
        return transitSwappedEventFlowable(filter);
    }

    public static List<UnpausedEventResponse> getUnpausedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(UNPAUSED_EVENT, transactionReceipt);
        ArrayList<UnpausedEventResponse> responses = new ArrayList<UnpausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnpausedEventResponse typedResponse = new UnpausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, UnpausedEventResponse>() {
            @Override
            public UnpausedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UNPAUSED_EVENT, log);
                UnpausedEventResponse typedResponse = new UnpausedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNPAUSED_EVENT));
        return unpausedEventFlowable(filter);
    }

    public static List<WithdrawEventResponse> getWithdrawEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(WITHDRAW_EVENT, transactionReceipt);
        ArrayList<WithdrawEventResponse> responses = new ArrayList<WithdrawEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawEventResponse typedResponse = new WithdrawEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.recipient = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, WithdrawEventResponse>() {
            @Override
            public WithdrawEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAW_EVENT, log);
                WithdrawEventResponse typedResponse = new WithdrawEventResponse();
                typedResponse.log = log;
                typedResponse.token = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.recipient = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAW_EVENT));
        return withdrawEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawTokens(List<String> tokens, String recipient) {
        final Function function = new Function(
                FUNC_WITHDRAWTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(tokens, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.Address(160, recipient)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> executor() {
        final Function function = new Function(FUNC_EXECUTOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> paused() {
        final Function function = new Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> pendingExecutor() {
        final Function function = new Function(FUNC_PENDINGEXECUTOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> pendingOwner() {
        final Function function = new Function(FUNC_PENDINGOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> swapTypeMode(BigInteger swapType) {
        final Function function = new Function(FUNC_SWAPTYPEMODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(swapType)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> transitCross() {
        final Function function = new Function(FUNC_TRANSITCROSS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> transitFees() {
        final Function function = new Function(FUNC_TRANSITFEES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> transitSwap() {
        final Function function = new Function(FUNC_TRANSITSWAP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> wrappedAllowed(String wrapped) {
        final Function function = new Function(FUNC_WRAPPEDALLOWED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, wrapped)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static TransitSwapRouterV4 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransitSwapRouterV4(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TransitSwapRouterV4 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransitSwapRouterV4(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TransitSwapRouterV4 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TransitSwapRouterV4(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TransitSwapRouterV4 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TransitSwapRouterV4(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class TransitSwapDescription extends DynamicStruct {
        public BigInteger swapType;

        public String srcToken;

        public String dstToken;

        public String srcReceiver;

        public String dstReceiver;

        public BigInteger amount;

        public BigInteger minReturnAmount;

        public String channel;

        public BigInteger toChainID;

        public String wrappedNative;

        public TransitSwapDescription(BigInteger swapType, String srcToken, String dstToken, String srcReceiver, String dstReceiver, BigInteger amount, BigInteger minReturnAmount, String channel, BigInteger toChainID, String wrappedNative) {
            super(new org.web3j.abi.datatypes.generated.Uint8(swapType), 
                    new org.web3j.abi.datatypes.Address(160, srcToken), 
                    new org.web3j.abi.datatypes.Address(160, dstToken), 
                    new org.web3j.abi.datatypes.Address(160, srcReceiver), 
                    new org.web3j.abi.datatypes.Address(160, dstReceiver), 
                    new org.web3j.abi.datatypes.generated.Uint256(amount), 
                    new org.web3j.abi.datatypes.generated.Uint256(minReturnAmount), 
                    new org.web3j.abi.datatypes.Utf8String(channel), 
                    new org.web3j.abi.datatypes.generated.Uint256(toChainID), 
                    new org.web3j.abi.datatypes.Address(160, wrappedNative));
            this.swapType = swapType;
            this.srcToken = srcToken;
            this.dstToken = dstToken;
            this.srcReceiver = srcReceiver;
            this.dstReceiver = dstReceiver;
            this.amount = amount;
            this.minReturnAmount = minReturnAmount;
            this.channel = channel;
            this.toChainID = toChainID;
            this.wrappedNative = wrappedNative;
        }

        public TransitSwapDescription(Uint8 swapType, Address srcToken, Address dstToken, Address srcReceiver, Address dstReceiver, Uint256 amount, Uint256 minReturnAmount, Utf8String channel, Uint256 toChainID, Address wrappedNative) {
            super(swapType, srcToken, dstToken, srcReceiver, dstReceiver, amount, minReturnAmount, channel, toChainID, wrappedNative);
            this.swapType = swapType.getValue();
            this.srcToken = srcToken.getValue();
            this.dstToken = dstToken.getValue();
            this.srcReceiver = srcReceiver.getValue();
            this.dstReceiver = dstReceiver.getValue();
            this.amount = amount.getValue();
            this.minReturnAmount = minReturnAmount.getValue();
            this.channel = channel.getValue();
            this.toChainID = toChainID.getValue();
            this.wrappedNative = wrappedNative.getValue();
        }
    }

    public static class CallbytesDescription extends DynamicStruct {
        public BigInteger flag;

        public String srcToken;

        public byte[] calldatas;

        public CallbytesDescription(BigInteger flag, String srcToken, byte[] calldatas) {
            super(new org.web3j.abi.datatypes.generated.Uint8(flag), 
                    new org.web3j.abi.datatypes.Address(160, srcToken), 
                    new org.web3j.abi.datatypes.DynamicBytes(calldatas));
            this.flag = flag;
            this.srcToken = srcToken;
            this.calldatas = calldatas;
        }

        public CallbytesDescription(Uint8 flag, Address srcToken, DynamicBytes calldatas) {
            super(flag, srcToken, calldatas);
            this.flag = flag.getValue();
            this.srcToken = srcToken.getValue();
            this.calldatas = calldatas.getValue();
        }
    }

    public static class ChangeSwapTypeModeEventResponse extends BaseEventResponse {
        public List<BigInteger> types;

        public List<Boolean> newModes;
    }

    public static class ChangeTransitCrossEventResponse extends BaseEventResponse {
        public String previousTransit;

        public String newTransit;
    }

    public static class ChangeTransitFeesEventResponse extends BaseEventResponse {
        public String previousTransitFees;

        public String newTransitFees;
    }

    public static class ChangeTransitSwapEventResponse extends BaseEventResponse {
        public String previousTransit;

        public String newTransit;
    }

    public static class ChangeWrappedAllowedEventResponse extends BaseEventResponse {
        public List<String> wrappeds;

        public List<Boolean> newAllowed;
    }

    public static class ExecutorshipTransferStartedEventResponse extends BaseEventResponse {
        public String previousExecutor;

        public String newExecutor;
    }

    public static class ExecutorshipTransferredEventResponse extends BaseEventResponse {
        public String previousExecutor;

        public String newExecutor;
    }

    public static class OwnershipTransferStartedEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class PausedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class ReceiptEventResponse extends BaseEventResponse {
        public String from;

        public BigInteger amount;
    }

    public static class TransitSourceEventResponse extends BaseEventResponse {
        public String source;
    }

    public static class TransitSwappedEventResponse extends BaseEventResponse {
        public String srcToken;

        public String dstToken;

        public String dstReceiver;

        public String trader;

        public Boolean feeMode;

        public BigInteger amount;

        public BigInteger returnAmount;

        public BigInteger minReturnAmount;

        public BigInteger fee;

        public BigInteger toChainID;

        public String channel;

        public BigInteger time;
    }

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class WithdrawEventResponse extends BaseEventResponse {
        public String token;

        public String executor;

        public String recipient;

        public BigInteger amount;
    }
}
