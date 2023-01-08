package com.mowitnow;

public enum Direction {

    N,
    E,
    W,
    S;

    private Direction right;
    private Direction left;

    public Direction getRight() {
        return right;
    }

    public Direction getLeft() {
        return left;
    }

    static {
        N.left = S.right = W;
        N.right = S.left = E;
        E.left = W.right = N;
        E.right = W.left = S;
    }

}
