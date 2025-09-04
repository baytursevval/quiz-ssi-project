const UserRegistry = artifacts.require("UserRegistry");

contract("UserRegistry", accounts => {
  it("should register and verify user hash", async () => {
    const registry = await UserRegistry.deployed();
    const hash = web3.utils.sha3("user@example.compassword123");

    await registry.registerUser(hash);
    const exists = await registry.verifyUser(hash);
    assert(exists === true, "User hash should exist in blockchain");
  });
});