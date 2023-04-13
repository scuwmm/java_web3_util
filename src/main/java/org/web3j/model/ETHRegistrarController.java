package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.abi.datatypes.generated.Uint64;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
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
public class ETHRegistrarController extends Contract {
    public static final String BINARY = "0x6101406040523480156200001257600080fd5b50604051620028bb380380620028bb83398101604081905262000035916200011a565b6200004033620000b1565b83831162000061576040516307cb550760e31b815260040160405180910390fd5b428311156200008357604051630b4319e560e21b815260040160405180910390fd5b6001600160a01b0395861660805293851660a05260c09290925260e052821661010052166101205262000197565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b6001600160a01b03811681146200011757600080fd5b50565b60008060008060008060c087890312156200013457600080fd5b8651620001418162000101565b6020880151909650620001548162000101565b8095505060408701519350606087015192506080870151620001768162000101565b60a0880151909250620001898162000101565b809150509295509295509295565b60805160a05160c05160e051610100516101205161269562000226600039600081816103ab015281816108b601528181610b4b015261152201526000818161024601526119100152600081816104120152818161108a015261173801526000818161032c01526116c10152600081816104460152610d97015260008181610dd90152610f3e01526126956000f3fe6080604052600436106101755760003560e01c80638d839ffe116100cb578063aeb8ce9b1161007f578063d555254a11610059578063d555254a14610468578063f14fcbc814610488578063f2fde38b146104a857600080fd5b8063aeb8ce9b146103e0578063ce1e09c014610400578063d3419bf31461043457600080fd5b80639791c097116100b05780639791c09714610379578063a8e5fbc014610399578063acf1a841146103cd57600080fd5b80638d839ffe1461031a5780638da5cb5b1461034e57600080fd5b8063715018a61161012d578063839df94511610107578063839df9451461028d57806383e7f6ff146102c85780638a95b09f1461030357600080fd5b8063715018a61461020c5780637acaaf2614610221578063808698531461023457600080fd5b80633ccfd60b1161015e5780633ccfd60b146101c45780635d3590d5146101d95780636459220f146101f957600080fd5b806301ffc9a71461017a57806315a2b739146101af575b600080fd5b34801561018657600080fd5b5061019a6101953660046119cf565b6104c8565b60405190151581526020015b60405180910390f35b6101c26101bd366004611a11565b610561565b005b3480156101d057600080fd5b506101c26106aa565b3480156101e557600080fd5b506101c26101f4366004611a71565b6106f4565b6101c2610207366004611b22565b610819565b34801561021857600080fd5b506101c2610987565b6101c261022f366004611be3565b610a14565b34801561024057600080fd5b506102687f000000000000000000000000000000000000000000000000000000000000000081565b60405173ffffffffffffffffffffffffffffffffffffffff90911681526020016101a6565b34801561029957600080fd5b506102ba6102a8366004611cbc565b60016020526000908152604090205481565b6040519081526020016101a6565b3480156102d457600080fd5b506102e86102e3366004611db3565b610d4d565b604080518251815260209283015192810192909252016101a6565b34801561030f57600080fd5b506102ba6224ea0081565b34801561032657600080fd5b506102ba7f000000000000000000000000000000000000000000000000000000000000000081565b34801561035a57600080fd5b5060005473ffffffffffffffffffffffffffffffffffffffff16610268565b34801561038557600080fd5b5061019a610394366004611df8565b610ead565b3480156103a557600080fd5b506102687f000000000000000000000000000000000000000000000000000000000000000081565b6101c26103db366004611e2d565b610ee2565b3480156103ec57600080fd5b5061019a6103fb366004611df8565b610ef5565b34801561040c57600080fd5b506102ba7f000000000000000000000000000000000000000000000000000000000000000081565b34801561044057600080fd5b506102687f000000000000000000000000000000000000000000000000000000000000000081565b34801561047457600080fd5b506102ba610483366004611e79565b610fc5565b34801561049457600080fd5b506101c26104a3366004611cbc565b611073565b3480156104b457600080fd5b506101c26104c3366004611f4c565b6110fc565b60007fffffffff0000000000000000000000000000000000000000000000000000000082167f01ffc9a700000000000000000000000000000000000000000000000000000000148061055b57507fffffffff0000000000000000000000000000000000000000000000000000000082167fcadc66b800000000000000000000000000000000000000000000000000000000145b92915050565b600a6105ae610574610120840184611f67565b8080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525061122992505050565b11156105b957600080fd5b6106306105c68280611f67565b6105d66040850160208601611f4c565b604085013560608601356105f060a0880160808901611f4c565b6105fd60a0890189611fcc565b61060d60e08b0160c08c01612034565b61061e6101008c0160e08d01612051565b61022f6101208d016101008e0161206c565b6106406040820160208301611f4c565b73ffffffffffffffffffffffffffffffffffffffff167fbfe313b7348ca4ae38e3d7c768c9be5f92b3e11d470ae430fb7bbda8b917b6bd6106818380611f67565b61068f610120860186611f67565b60405161069f94939291906120b2565b60405180910390a250565b6000805460405173ffffffffffffffffffffffffffffffffffffffff909116914780156108fc02929091818181858888f193505050501580156106f1573d6000803e3d6000fd5b50565b60005473ffffffffffffffffffffffffffffffffffffffff16331461077a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e657260448201526064015b60405180910390fd5b6040517fa9059cbb00000000000000000000000000000000000000000000000000000000815273ffffffffffffffffffffffffffffffffffffffff83811660048301526024820183905284169063a9059cbb906044016020604051808303816000875af11580156107ef573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061081391906120e4565b50505050565b6000858560405161082b929190612101565b604080519182900382207ff7371317c100d5b60d3ccb1738fb0e94c7aded59790cd01aa2aba4798434e7bf6020840152908201819052915060009060600160408051808303601f190181529082905280516020909101207ff44779b90000000000000000000000000000000000000000000000000000000082526004820181905233602483015291507f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff169063f44779b9906044016020604051808303816000875af1158015610914573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061093891906120e4565b610971576040517fe4fd57ae00000000000000000000000000000000000000000000000000000000815260048101829052602401610771565b61097e8787878787611430565b50505050505050565b60005473ffffffffffffffffffffffffffffffffffffffff163314610a08576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610771565b610a126000611635565b565b6000610a578c8c8080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152508d9250610d4d915050565b60208101518151919250610a6a91612140565b341015610aa3576040517f1101129400000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b610b478c8c8080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050508a610b428f8f8080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050508e8e8e8e8e8e8e8e8e610fc5565b6116aa565b60007f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff16639f56dac68e8e8e8e8d8a8a6040518863ffffffff1660e01b8152600401610bae9796959493929190612153565b6020604051808303816000875af1158015610bcd573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610bf191906121bd565b90508515610c1c57610c1c888e8e604051610c0d929190612101565b60405180910390208989611827565b8415610c6557610c658d8d8080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152508c925033915061190e9050565b8a73ffffffffffffffffffffffffffffffffffffffff168d8d604051610c8c929190612101565b60405180910390207f69e37f151eb98a09618ddaa80c8cfaf1ce5996867c489f45b555b412271ebf278f8f8660000151876020015187604051610cd39594939291906121d6565b60405180910390a360208201518251610cec9190612140565b341115610d3e576020820151825133916108fc91610d0a9190612140565b610d149034612207565b6040518115909202916000818181858888f19350505050158015610d3c573d6000803e3d6000fd5b505b50505050505050505050505050565b6040805180820190915260008082526020820152825160208401206040517fd6e4fa86000000000000000000000000000000000000000000000000000000008152600481018290527f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff908116916350e9a7159187917f00000000000000000000000000000000000000000000000000000000000000009091169063d6e4fa8690602401602060405180830381865afa158015610e22573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610e4691906121bd565b866040518463ffffffff1660e01b8152600401610e659392919061226a565b6040805180830381865afa158015610e81573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610ea5919061228f565b949350505050565b6000610eb882611229565b825103610ed2576003610eca83611229565b101592915050565b6002610eca83611229565b919050565b610ef0838383600080611430565b505050565b80516020820120600090610f0883610ead565b8015610fbe57506040517f96e494e8000000000000000000000000000000000000000000000000000000008152600481018290527f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff16906396e494e890602401602060405180830381865afa158015610f9a573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610fbe91906120e4565b9392505050565b895160208b01206000908515801590610ff2575073ffffffffffffffffffffffffffffffffffffffff8816155b15611029576040517fd3f605c400000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b808b8b8a8a8a8e8b8b8b60405160200161104c9a9998979695949392919061238e565b604051602081830303815290604052805190602001209150509a9950505050505050505050565b60008181526001602052604090205442906110af907f000000000000000000000000000000000000000000000000000000000000000090612140565b106110e9576040517f0a059d7100000000000000000000000000000000000000000000000000000000815260048101829052602401610771565b6000908152600160205260409020429055565b60005473ffffffffffffffffffffffffffffffffffffffff16331461117d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610771565b73ffffffffffffffffffffffffffffffffffffffff8116611220576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201527f64647265737300000000000000000000000000000000000000000000000000006064820152608401610771565b6106f181611635565b8051600090819081905b8082101561142757600085838151811061124f5761124f612410565b01602001517fff000000000000000000000000000000000000000000000000000000000000001690507f80000000000000000000000000000000000000000000000000000000000000008110156112b2576112ab600184612140565b9250611414565b7fe0000000000000000000000000000000000000000000000000000000000000007fff0000000000000000000000000000000000000000000000000000000000000082161015611307576112ab600284612140565b7ff0000000000000000000000000000000000000000000000000000000000000007fff000000000000000000000000000000000000000000000000000000000000008216101561135c576112ab600384612140565b7ff8000000000000000000000000000000000000000000000000000000000000007fff00000000000000000000000000000000000000000000000000000000000000821610156113b1576112ab600484612140565b7ffc000000000000000000000000000000000000000000000000000000000000007fff0000000000000000000000000000000000000000000000000000000000000082161015611406576112ab600584612140565b611411600684612140565b92505b508261141f8161243f565b935050611233565b50909392505050565b60008585604051611442929190612101565b604080519182900382206020601f89018190048102840181019092528783529250829160009161148f91908a908a90819084018382808284376000920191909152508a9250610d4d915050565b80519091503410156114cd576040517f1101129400000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b6040517f47d2e9fe000000000000000000000000000000000000000000000000000000008152600481018390526024810187905263ffffffff8616604482015267ffffffffffffffff851660648201526000907f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff16906347d2e9fe906084016020604051808303816000875af1158015611580573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906115a491906121bd565b82519091503411156115ec57815133906108fc906115c29034612207565b6040518115909202916000818181858888f193505050501580156115ea573d6000803e3d6000fd5b505b837f3da24c024582931cfaf8267d8ed24d13a82a8068d5bd337d30ec45cea4e506ae8a8a34856040516116229493929190612477565b60405180910390a2505050505050505050565b6000805473ffffffffffffffffffffffffffffffffffffffff8381167fffffffffffffffffffffffff0000000000000000000000000000000000000000831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b60008181526001602052604090205442906116e6907f000000000000000000000000000000000000000000000000000000000000000090612140565b1115611721576040517f5320bcf900000000000000000000000000000000000000000000000000000000815260048101829052602401610771565b600081815260016020526040902054429061175d907f000000000000000000000000000000000000000000000000000000000000000090612140565b11611797576040517fcb7690d700000000000000000000000000000000000000000000000000000000815260048101829052602401610771565b6117a083610ef5565b6117d857826040517f477707e8000000000000000000000000000000000000000000000000000000008152600401610771919061249e565b6000818152600160205260408120556224ea00821015610ef0576040517f9a71997b00000000000000000000000000000000000000000000000000000000815260048101839052602401610771565b604080517ff7371317c100d5b60d3ccb1738fb0e94c7aded59790cd01aa2aba4798434e7bf602080830191909152818301869052825180830384018152606083019384905280519101207fe32954eb00000000000000000000000000000000000000000000000000000000909252859073ffffffffffffffffffffffffffffffffffffffff82169063e32954eb906118c7908590889088906064016124b1565b6000604051808303816000875af11580156118e6573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405261097e91908101906124d4565b7f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff16637a806d6b3383858760405160200161195e91906125d3565b6040516020818303038152906040526040518563ffffffff1660e01b815260040161198c9493929190612614565b6020604051808303816000875af11580156119ab573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061081391906121bd565b6000602082840312156119e157600080fd5b81357fffffffff0000000000000000000000000000000000000000000000000000000081168114610fbe57600080fd5b600060208284031215611a2357600080fd5b813567ffffffffffffffff811115611a3a57600080fd5b82016101408185031215610fbe57600080fd5b803573ffffffffffffffffffffffffffffffffffffffff81168114610edd57600080fd5b600080600060608486031215611a8657600080fd5b611a8f84611a4d565b9250611a9d60208501611a4d565b9150604084013590509250925092565b60008083601f840112611abf57600080fd5b50813567ffffffffffffffff811115611ad757600080fd5b602083019150836020828501011115611aef57600080fd5b9250929050565b803563ffffffff81168114610edd57600080fd5b803567ffffffffffffffff81168114610edd57600080fd5b600080600080600060808688031215611b3a57600080fd5b853567ffffffffffffffff811115611b5157600080fd5b611b5d88828901611aad565b90965094505060208601359250611b7660408701611af6565b9150611b8460608701611b0a565b90509295509295909350565b60008083601f840112611ba257600080fd5b50813567ffffffffffffffff811115611bba57600080fd5b6020830191508360208260051b8501011115611aef57600080fd5b80151581146106f157600080fd5b60008060008060008060008060008060006101208c8e031215611c0557600080fd5b67ffffffffffffffff808d351115611c1c57600080fd5b611c298e8e358f01611aad565b909c509a50611c3a60208e01611a4d565b995060408d0135985060608d01359750611c5660808e01611a4d565b96508060a08e01351115611c6957600080fd5b50611c7a8d60a08e01358e01611b90565b909550935060c08c0135611c8d81611bd5565b9250611c9b60e08d01611af6565b9150611caa6101008d01611b0a565b90509295989b509295989b9093969950565b600060208284031215611cce57600080fd5b5035919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff81118282101715611d2d57611d2d611cd5565b604052919050565b600067ffffffffffffffff821115611d4f57611d4f611cd5565b50601f01601f191660200190565b600082601f830112611d6e57600080fd5b8135611d81611d7c82611d35565b611d04565b818152846020838601011115611d9657600080fd5b816020850160208301376000918101602001919091529392505050565b60008060408385031215611dc657600080fd5b823567ffffffffffffffff811115611ddd57600080fd5b611de985828601611d5d565b95602094909401359450505050565b600060208284031215611e0a57600080fd5b813567ffffffffffffffff811115611e2157600080fd5b610ea584828501611d5d565b600080600060408486031215611e4257600080fd5b833567ffffffffffffffff811115611e5957600080fd5b611e6586828701611aad565b909790965060209590950135949350505050565b6000806000806000806000806000806101208b8d031215611e9957600080fd5b8a3567ffffffffffffffff80821115611eb157600080fd5b611ebd8e838f01611d5d565b9b50611ecb60208e01611a4d565b9a5060408d0135995060608d01359850611ee760808e01611a4d565b975060a08d0135915080821115611efd57600080fd5b50611f0a8d828e01611b90565b90965094505060c08b0135611f1e81611bd5565b9250611f2c60e08c01611af6565b9150611f3b6101008c01611b0a565b90509295989b9194979a5092959850565b600060208284031215611f5e57600080fd5b610fbe82611a4d565b60008083357fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe1843603018112611f9c57600080fd5b83018035915067ffffffffffffffff821115611fb757600080fd5b602001915036819003821315611aef57600080fd5b60008083357fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe184360301811261200157600080fd5b83018035915067ffffffffffffffff82111561201c57600080fd5b6020019150600581901b3603821315611aef57600080fd5b60006020828403121561204657600080fd5b8135610fbe81611bd5565b60006020828403121561206357600080fd5b610fbe82611af6565b60006020828403121561207e57600080fd5b610fbe82611b0a565b818352818160208501375060006020828401015260006020601f19601f840116840101905092915050565b6040815260006120c6604083018688612087565b82810360208401526120d9818587612087565b979650505050505050565b6000602082840312156120f657600080fd5b8151610fbe81611bd5565b8183823760009101908152919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b8082018082111561055b5761055b612111565b60c08152600061216760c08301898b612087565b905073ffffffffffffffffffffffffffffffffffffffff808816602084015286604084015280861660608401525063ffffffff8416608083015267ffffffffffffffff831660a083015298975050505050505050565b6000602082840312156121cf57600080fd5b5051919050565b6080815260006121ea608083018789612087565b602083019590955250604081019290925260609091015292915050565b8181038181111561055b5761055b612111565b60005b8381101561223557818101518382015260200161221d565b50506000910152565b6000815180845261225681602086016020860161221a565b601f01601f19169290920160200192915050565b60608152600061227d606083018661223e565b60208301949094525060400152919050565b6000604082840312156122a157600080fd5b6040516040810181811067ffffffffffffffff821117156122c4576122c4611cd5565b604052825181526020928301519281019290925250919050565b81835260006020808501808196508560051b810191508460005b8781101561238157828403895281357fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe188360301811261233757600080fd5b8701858101903567ffffffffffffffff81111561235357600080fd5b80360382131561236257600080fd5b61236d868284612087565b9a87019a95505050908401906001016122f8565b5091979650505050505050565b60006101208c835273ffffffffffffffffffffffffffffffffffffffff808d1660208501528b6040850152808b166060850152508060808401526123d5818401898b6122de565b60a0840197909752505092151560c084015263ffffffff9190911660e083015267ffffffffffffffff16610100909101529695505050505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b60007fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff820361247057612470612111565b5060010190565b60608152600061248b606083018688612087565b6020830194909452506040015292915050565b602081526000610fbe602083018461223e565b8381526040602082015260006124cb6040830184866122de565b95945050505050565b600060208083850312156124e757600080fd5b825167ffffffffffffffff808211156124ff57600080fd5b818501915085601f83011261251357600080fd5b81518181111561252557612525611cd5565b8060051b612534858201611d04565b918252838101850191858101908984111561254e57600080fd5b86860192505b838310156125c65782518581111561256c5760008081fd5b8601603f81018b1361257e5760008081fd5b878101516040612590611d7c83611d35565b8281528d828486010111156125a55760008081fd5b6125b4838c830184870161221a565b85525050509186019190860190612554565b9998505050505050505050565b600082516125e581846020870161221a565b7f2e736e7300000000000000000000000000000000000000000000000000000000920191825250600401919050565b600073ffffffffffffffffffffffffffffffffffffffff8087168352808616602084015280851660408401525060806060830152612655608083018461223e565b969550505050505056fea2646970667358221220d3b4f70b4bb95f91a1d9a8304fd266f13d9c0edf7be13599055d88f57701506a64736f6c63430008110033";

    public static final String FUNC_MIN_REGISTRATION_DURATION = "MIN_REGISTRATION_DURATION";

    public static final String FUNC_AVAILABLE = "available";

    public static final String FUNC_COMMIT = "commit";

    public static final String FUNC_COMMITMENTS = "commitments";

    public static final String FUNC_MAKECOMMITMENT = "makeCommitment";

    public static final String FUNC_MAXCOMMITMENTAGE = "maxCommitmentAge";

    public static final String FUNC_MINCOMMITMENTAGE = "minCommitmentAge";

    public static final String FUNC_NAMEWRAPPER = "nameWrapper";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PRICES = "prices";

    public static final String FUNC_RECOVERFUNDS = "recoverFunds";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_REGISTERWITHINVITECODE = "registerWithInviteCode";

    public static final String FUNC_RENEW = "renew";

    public static final String FUNC_RENEWWITHFUSES = "renewWithFuses";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_RENTPRICE = "rentPrice";

    public static final String FUNC_REVERSEREGISTRAR = "reverseRegistrar";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_VALID = "valid";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event NAMEINVITED_EVENT = new Event("NameInvited", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event NAMEREGISTERED_EVENT = new Event("NameRegistered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NAMERENEWED_EVENT = new Event("NameRenewed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ETHRegistrarController(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ETHRegistrarController(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ETHRegistrarController(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ETHRegistrarController(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<NameInvitedEventResponse> getNameInvitedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NAMEINVITED_EVENT, transactionReceipt);
        ArrayList<NameInvitedEventResponse> responses = new ArrayList<NameInvitedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NameInvitedEventResponse typedResponse = new NameInvitedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.inviteCode = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NameInvitedEventResponse> nameInvitedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NameInvitedEventResponse>() {
            @Override
            public NameInvitedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NAMEINVITED_EVENT, log);
                NameInvitedEventResponse typedResponse = new NameInvitedEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.inviteCode = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NameInvitedEventResponse> nameInvitedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NAMEINVITED_EVENT));
        return nameInvitedEventFlowable(filter);
    }

    public static List<NameRegisteredEventResponse> getNameRegisteredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NAMEREGISTERED_EVENT, transactionReceipt);
        ArrayList<NameRegisteredEventResponse> responses = new ArrayList<NameRegisteredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NameRegisteredEventResponse typedResponse = new NameRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.baseCost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.premium = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NameRegisteredEventResponse> nameRegisteredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NameRegisteredEventResponse>() {
            @Override
            public NameRegisteredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NAMEREGISTERED_EVENT, log);
                NameRegisteredEventResponse typedResponse = new NameRegisteredEventResponse();
                typedResponse.log = log;
                typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.baseCost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.premium = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NameRegisteredEventResponse> nameRegisteredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NAMEREGISTERED_EVENT));
        return nameRegisteredEventFlowable(filter);
    }

    public static List<NameRenewedEventResponse> getNameRenewedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NAMERENEWED_EVENT, transactionReceipt);
        ArrayList<NameRenewedEventResponse> responses = new ArrayList<NameRenewedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NameRenewedEventResponse typedResponse = new NameRenewedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NameRenewedEventResponse> nameRenewedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NameRenewedEventResponse>() {
            @Override
            public NameRenewedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NAMERENEWED_EVENT, log);
                NameRenewedEventResponse typedResponse = new NameRenewedEventResponse();
                typedResponse.log = log;
                typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NameRenewedEventResponse> nameRenewedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NAMERENEWED_EVENT));
        return nameRenewedEventFlowable(filter);
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
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
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

    public RemoteFunctionCall<BigInteger> MIN_REGISTRATION_DURATION() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MIN_REGISTRATION_DURATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> available(String name) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AVAILABLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> commit(byte[] commitment) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_COMMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(commitment)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> commitments(byte[] param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COMMITMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> makeCommitment(String name, String owner, BigInteger duration, byte[] secret, String resolver, List<byte[]> data, Boolean reverseRecord, BigInteger fuses, BigInteger wrapperExpiry) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAKECOMMITMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.generated.Uint256(duration), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                new org.web3j.abi.datatypes.Address(160, resolver), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.Bool(reverseRecord), 
                new org.web3j.abi.datatypes.generated.Uint32(fuses), 
                new org.web3j.abi.datatypes.generated.Uint64(wrapperExpiry)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> maxCommitmentAge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXCOMMITMENTAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> minCommitmentAge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINCOMMITMENTAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> nameWrapper() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAMEWRAPPER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> prices() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PRICES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> recoverFunds(String _token, String _to, BigInteger _amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECOVERFUNDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _token), 
                new org.web3j.abi.datatypes.Address(160, _to), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> register(String name, String owner, BigInteger duration, byte[] secret, String resolver, List<byte[]> data, Boolean reverseRecord, BigInteger fuses, BigInteger wrapperExpiry, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.generated.Uint256(duration), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                new org.web3j.abi.datatypes.Address(160, resolver), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.Bool(reverseRecord), 
                new org.web3j.abi.datatypes.generated.Uint32(fuses), 
                new org.web3j.abi.datatypes.generated.Uint64(wrapperExpiry)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> registerWithInviteCode(RegisterData resData, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERWITHINVITECODE, 
                Arrays.<Type>asList(resData), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> renew(String name, BigInteger duration, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENEW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.generated.Uint256(duration)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> renewWithFuses(String name, BigInteger duration, BigInteger fuses, BigInteger wrapperExpiry, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENEWWITHFUSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.generated.Uint256(duration), 
                new org.web3j.abi.datatypes.generated.Uint32(fuses), 
                new org.web3j.abi.datatypes.generated.Uint64(wrapperExpiry)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Price> rentPrice(String name, BigInteger duration) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RENTPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.generated.Uint256(duration)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Price>() {}));
        return executeRemoteCallSingleValueReturn(function, Price.class);
    }

    public RemoteFunctionCall<String> reverseRegistrar() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_REVERSEREGISTRAR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> valid(String name) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VALID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ETHRegistrarController load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ETHRegistrarController(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ETHRegistrarController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ETHRegistrarController(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ETHRegistrarController load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ETHRegistrarController(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ETHRegistrarController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ETHRegistrarController(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ETHRegistrarController> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge, String _reverseRegistrar, String _nameWrapper) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _base), 
                new org.web3j.abi.datatypes.Address(160, _prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge), 
                new org.web3j.abi.datatypes.Address(160, _reverseRegistrar), 
                new org.web3j.abi.datatypes.Address(160, _nameWrapper)));
        return deployRemoteCall(ETHRegistrarController.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ETHRegistrarController> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge, String _reverseRegistrar, String _nameWrapper) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _base), 
                new org.web3j.abi.datatypes.Address(160, _prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge), 
                new org.web3j.abi.datatypes.Address(160, _reverseRegistrar), 
                new org.web3j.abi.datatypes.Address(160, _nameWrapper)));
        return deployRemoteCall(ETHRegistrarController.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ETHRegistrarController> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge, String _reverseRegistrar, String _nameWrapper) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _base), 
                new org.web3j.abi.datatypes.Address(160, _prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge), 
                new org.web3j.abi.datatypes.Address(160, _reverseRegistrar), 
                new org.web3j.abi.datatypes.Address(160, _nameWrapper)));
        return deployRemoteCall(ETHRegistrarController.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ETHRegistrarController> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge, String _reverseRegistrar, String _nameWrapper) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _base), 
                new org.web3j.abi.datatypes.Address(160, _prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge), 
                new org.web3j.abi.datatypes.Address(160, _reverseRegistrar), 
                new org.web3j.abi.datatypes.Address(160, _nameWrapper)));
        return deployRemoteCall(ETHRegistrarController.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class RegisterData extends DynamicStruct {
        public String name;

        public String owner;

        public BigInteger duration;

        public byte[] secret;

        public String resolver;

        public List<byte[]> data;

        public Boolean reverseRecord;

        public BigInteger fuses;

        public BigInteger wrapperExpiry;

        public String inviteCode;

        public RegisterData(String name, String owner, BigInteger duration, byte[] secret, String resolver, List<byte[]> data, Boolean reverseRecord, BigInteger fuses, BigInteger wrapperExpiry, String inviteCode) {
            super(new org.web3j.abi.datatypes.Utf8String(name), 
                    new org.web3j.abi.datatypes.Address(160, owner), 
                    new org.web3j.abi.datatypes.generated.Uint256(duration), 
                    new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                    new org.web3j.abi.datatypes.Address(160, resolver), 
                    new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                            org.web3j.abi.datatypes.DynamicBytes.class,
                            org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.DynamicBytes.class)), 
                    new org.web3j.abi.datatypes.Bool(reverseRecord), 
                    new org.web3j.abi.datatypes.generated.Uint32(fuses), 
                    new org.web3j.abi.datatypes.generated.Uint64(wrapperExpiry), 
                    new org.web3j.abi.datatypes.Utf8String(inviteCode));
            this.name = name;
            this.owner = owner;
            this.duration = duration;
            this.secret = secret;
            this.resolver = resolver;
            this.data = data;
            this.reverseRecord = reverseRecord;
            this.fuses = fuses;
            this.wrapperExpiry = wrapperExpiry;
            this.inviteCode = inviteCode;
        }

        public RegisterData(Utf8String name, Address owner, Uint256 duration, Bytes32 secret, Address resolver, DynamicArray<DynamicBytes> data, Bool reverseRecord, Uint32 fuses, Uint64 wrapperExpiry, Utf8String inviteCode) {
            super(name, owner, duration, secret, resolver, data, reverseRecord, fuses, wrapperExpiry, inviteCode);
            this.name = name.getValue();
            this.owner = owner.getValue();
            this.duration = duration.getValue();
            this.secret = secret.getValue();
            this.resolver = resolver.getValue();
            this.data = data.getValue().stream().map(v -> v.getValue()).collect(Collectors.toList());
            this.reverseRecord = reverseRecord.getValue();
            this.fuses = fuses.getValue();
            this.wrapperExpiry = wrapperExpiry.getValue();
            this.inviteCode = inviteCode.getValue();
        }
    }

    public static class Price extends StaticStruct {
        public BigInteger base;

        public BigInteger premium;

        public Price(BigInteger base, BigInteger premium) {
            super(new org.web3j.abi.datatypes.generated.Uint256(base), 
                    new org.web3j.abi.datatypes.generated.Uint256(premium));
            this.base = base;
            this.premium = premium;
        }

        public Price(Uint256 base, Uint256 premium) {
            super(base, premium);
            this.base = base.getValue();
            this.premium = premium.getValue();
        }
    }

    public static class NameInvitedEventResponse extends BaseEventResponse {
        public String owner;

        public String name;

        public String inviteCode;
    }

    public static class NameRegisteredEventResponse extends BaseEventResponse {
        public byte[] label;

        public String owner;

        public String name;

        public BigInteger baseCost;

        public BigInteger premium;

        public BigInteger expires;
    }

    public static class NameRenewedEventResponse extends BaseEventResponse {
        public byte[] label;

        public String name;

        public BigInteger cost;

        public BigInteger expires;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
