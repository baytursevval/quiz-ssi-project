// SPDX-License-Identifier: MIT
pragma solidity ^0.8.10;

contract UserRegistry {
    mapping(bytes32 => bool) private users;

    function registerUser(bytes32 userHash) public {
        require(!users[userHash], "User already exists");
        users[userHash] = true;
    }

    function verifyUser(bytes32 userHash) public view returns (bool) {
        return users[userHash];
    }
}