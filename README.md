# Blockchain-based Voting System

This project is a simple implementation of a Blockchain-based Voting System in Java. It utilizes a basic Blockchain data structure to store the votes securely and immutably.

## Overview

The Voting System consists of two main components:

1. **Block**: Represents a single block in the Blockchain. Each block contains the vote data, the hash of the previous block, and its own hash.
2. **Blockchain**: Manages the blocks and provides methods for adding blocks and validating the chain.

## How it works

1. **Block**: The Block class represents a single block in the Blockchain. It contains methods to calculate its own hash and store vote data.
2. **Blockchain**: The Blockchain class manages the blocks. It initializes with a genesis block and provides methods to add new blocks and validate the chain's integrity.

## Usage

To use the Blockchain-based Voting System, follow these steps:

1. **Initialize Blockchain**: Create a new instance of the Blockchain class.
2. **Cast Votes**: Add blocks to the blockchain with the vote data.
3. **Validation**: Verify the integrity of the blockchain with the `isChainValid()` method.

```java
Blockchain blockchain = new Blockchain();
blockchain.addBlock("Vote for Candidate A", blockchain.getLatestBlock().getHash());
blockchain.addBlock("Vote for Candidate B", blockchain.getLatestBlock().getHash());

System.out.println("Blockchain is valid: " + blockchain.isChainValid());

```

## Features

- Secure and immutable storage of votes using Blockchain technology.
- Proof-of-concept implementation for a voting system.
- Simple and easy-to-understand Java code.

## Contributions

Contributions are welcome! Feel free to submit issues or pull requests for any improvements or additional features.
