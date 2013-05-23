package com.od.filtertable.suffixtree;

/**
 * User: nick
 * Date: 22/05/13
 * Time: 17:28
 */
public interface SuffixTreeVisitor<V> {

    /**
     * @return true if visitation should continue
     */
    boolean visit(SuffixTree<V> suffixTree);
    
    void visitComplete(SuffixTree<V> suffixTree);
}