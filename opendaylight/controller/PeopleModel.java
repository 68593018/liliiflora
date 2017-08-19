/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */


package org.opendaylight.controller.md.cluster.datastore.model;

import java.math.BigInteger;

import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.data.api.YangInstanceIdentifier;
import org.opendaylight.yangtools.yang.data.api.YangInstanceIdentifier.NodeIdentifier;
import org.opendaylight.yangtools.yang.data.api.YangInstanceIdentifier.NodeWithValue;
import org.opendaylight.yangtools.yang.data.api.schema.ContainerNode;
import org.opendaylight.yangtools.yang.data.api.schema.LeafSetEntryNode;
import org.opendaylight.yangtools.yang.data.api.schema.LeafSetNode;
import org.opendaylight.yangtools.yang.data.api.schema.MapEntryNode;
import org.opendaylight.yangtools.yang.data.api.schema.MapNode;
import org.opendaylight.yangtools.yang.data.api.schema.NormalizedNode;
import org.opendaylight.yangtools.yang.data.impl.schema.ImmutableNodes;
import org.opendaylight.yangtools.yang.data.impl.schema.builder.api.CollectionNodeBuilder;
import org.opendaylight.yangtools.yang.data.impl.schema.builder.api.ListNodeBuilder;
import org.opendaylight.yangtools.yang.data.impl.schema.builder.impl.ImmutableContainerNodeBuilder;
import org.opendaylight.yangtools.yang.data.impl.schema.builder.impl.ImmutableLeafSetEntryNodeBuilder;
import org.opendaylight.yangtools.yang.data.impl.schema.builder.impl.ImmutableLeafSetNodeBuilder;
import org.opendaylight.yangtools.yang.data.impl.schema.builder.impl.ImmutableMapNodeBuilder;

public class PeopleModel {
    public static final QName BASE_QNAME = QName.create("urn:opendaylight:etdstore:people", "2014-03-13", "peoples");

    public static final QName PEOPLE_QNAME = QName.create(BASE_QNAME, "peoples");
    public static final QName PERSON_QNAME = QName.create(PEOPLE_QNAME, "person");
    public static final QName PERSON_NAME_QNAME = QName.create(PERSON_QNAME, "name");
    public static final QName PERSON_AGE_QNAME = QName.create(PERSON_QNAME, "age");

    public static final YangInstanceIdentifier BASE_PATH = YangInstanceIdentifier.of(BASE_QNAME);
    public static final YangInstanceIdentifier PERSON_LIST_PATH = BASE_PATH.node(PERSON_QNAME);

    public static final QName CAR_QNAME = QName.create(PERSON_QNAME, "car");
    public static final QName CAR_BRAND_QNAME = QName.create(CAR_QNAME, "brand");
    public static final QName CAR_PRICE_QNAME = QName.create(CAR_QNAME, "price");

    public static final YangInstanceIdentifier CAR_LIST_PATH = PERSON_LIST_PATH.node(CAR_QNAME);

    private static final QName NATIONLITY_QNAME = QName.create(PERSON_QNAME, "nationality");
    private static final YangInstanceIdentifier NATIONLITY_LEAF_LIST_PATH = PERSON_LIST_PATH.node(NATIONLITY_QNAME);

    public static NormalizedNode<?, ?> create() {
        MapEntryNode ford = newCarEntry("ford", new BigInteger("1000"));
        MapEntryNode bmw = newCarEntry("bmw", new BigInteger("2000"));
        MapEntryNode benz = newCarEntry("benz", new BigInteger("3000"));

        MapNode cars = newCarsMapNode(ford, bmw, benz);

        MapEntryNode jack = newPersonEntry("jack", new Long(25), cars);
        MapEntryNode tom = newPersonEntry("tom", new Long(27), cars);

        MapNode persons = newPersonsMapNode(jack, tom);

        return newPeopleNode(persons);
    }

    public static NormalizedNode<?, ?> create1() {
        final LeafSetEntryNode<Object> china = newNationlityEntry("China");
        final LeafSetEntryNode<Object> american = newNationlityEntry("American");

        final LeafSetNode<Object> nationlity = newNationlityLeafSetNode(china, american);

        final MapEntryNode ford = newCarEntry("ford", new BigInteger("1000"));
        final MapEntryNode bmw = newCarEntry("bmw", new BigInteger("2000"));
        final MapEntryNode benz = newCarEntry("benz", new BigInteger("3000"));

        final MapNode cars = newCarsMapNode(ford, bmw, benz);

        final MapEntryNode jack = newPersonEntry("jack", new Long(25), cars);
        final MapEntryNode tom = newPersonEntry("tom", new Long(27), cars);
        final MapEntryNode liming = newPersonEntry("liming", new Long(30), cars, nationlity);

        final MapNode persons = newPersonsMapNode(jack, tom, liming);

        return newPeopleNode(persons);
    }

    public static NormalizedNode<?, ?> emptyContainer(){
        return ImmutableContainerNodeBuilder.create()
            .withNodeIdentifier(
                new YangInstanceIdentifier.NodeIdentifier(BASE_QNAME))
            .build();
    }

    public static NormalizedNode<?, ?> newPersonMapNode() {
        return ImmutableNodes.mapNodeBuilder(PERSON_QNAME).build();
    }

    public static ContainerNode newPeopleNode(MapNode personsList) {
        return ImmutableContainerNodeBuilder.create().withNodeIdentifier(new YangInstanceIdentifier.NodeIdentifier(
                BASE_QNAME)).withChild(personsList).build();
    }

    /* Construct list-entry person */
    public static MapEntryNode newPersonEntry(String name) {
        return ImmutableNodes.mapEntryBuilder(PERSON_QNAME, PERSON_NAME_QNAME, name)
                .withChild(ImmutableNodes.leafNode(PERSON_NAME_QNAME, name)).build();
    }

    /* Construct list-entry person */
    public static MapEntryNode newPersonEntry(String name, Long age) {
        return ImmutableNodes.mapEntryBuilder(PERSON_QNAME, PERSON_NAME_QNAME, name)
                .withChild(ImmutableNodes.leafNode(PERSON_NAME_QNAME, name))
                .withChild(ImmutableNodes.leafNode(PERSON_AGE_QNAME, age)).build();
    }

    /* Construct list-entry person */
    public static MapEntryNode newPersonEntry(String name, Long age, MapNode cars) {
        return ImmutableNodes.mapEntryBuilder(PERSON_QNAME, PERSON_NAME_QNAME, name)
                .withChild(ImmutableNodes.leafNode(PERSON_NAME_QNAME, name))
                .withChild(ImmutableNodes.leafNode(PERSON_AGE_QNAME, age))
                .withChild(cars).build();
    }

    /* Construct list-entry person */
    public static MapEntryNode newPersonEntry(String name, Long age, MapNode cars, LeafSetNode<Object> nationality) {
        return ImmutableNodes.mapEntryBuilder(PERSON_QNAME, PERSON_NAME_QNAME, name)
                .withChild(ImmutableNodes.leafNode(PERSON_NAME_QNAME, name))
                .withChild(ImmutableNodes.leafNode(PERSON_AGE_QNAME, age))
                .withChild(cars).withChild(nationality).build();
    }

    /* Construct list person */
    public static MapNode newPersonsMapNode(MapEntryNode... personEntries) {
        CollectionNodeBuilder<MapEntryNode, MapNode> builder = ImmutableMapNodeBuilder.create()
                .withNodeIdentifier(new YangInstanceIdentifier.NodeIdentifier(PERSON_QNAME));
        for (MapEntryNode e: personEntries) {
            builder.withChild(e);
        }

        return builder.build();
    }

    /* Construct list-entry car */
    public static MapEntryNode newCarEntry(String brand) {
        return ImmutableNodes.mapEntryBuilder(CAR_QNAME, CAR_BRAND_QNAME, brand)
                .withChild(ImmutableNodes.leafNode(CAR_BRAND_QNAME, brand)).build();
    }

    /* Construct list-entry car */
    public static MapEntryNode newCarEntry(String brand, BigInteger price) {
        return ImmutableNodes.mapEntryBuilder(CAR_QNAME, CAR_BRAND_QNAME, brand)
                .withChild(ImmutableNodes.leafNode(CAR_BRAND_QNAME, brand))
                .withChild(ImmutableNodes.leafNode(CAR_PRICE_QNAME, price)).build();
    }

    /* Construct list car */
    public static MapNode newCarsMapNode(MapEntryNode... carEntries) {
        CollectionNodeBuilder<MapEntryNode, MapNode> builder = ImmutableMapNodeBuilder.create()
                .withNodeIdentifier(new YangInstanceIdentifier.NodeIdentifier(CAR_QNAME));
        for (MapEntryNode e: carEntries) {
            builder.withChild(e);
        }

        return builder.build();
    }

    /* Construct leaf-list-entry nationality */
    public static LeafSetEntryNode<Object> newNationlityEntry(String nationality) {
        final NodeWithValue<?> path = new NodeWithValue<>(NATIONLITY_QNAME, nationality);

        final LeafSetEntryNode<Object> leafSetEntry = ImmutableLeafSetEntryNodeBuilder.create()
                .withNodeIdentifier(path)
                .withValue(nationality).build();

        return leafSetEntry;
    }

    public static LeafSetNode<Object> newNationlityLeafSetNode(LeafSetEntryNode<Object>... nationalityEntries) {
        final ListNodeBuilder<Object, LeafSetEntryNode<Object>> builder =
                    ImmutableLeafSetNodeBuilder.create().withNodeIdentifier(new NodeIdentifier(NATIONLITY_QNAME));
        for (LeafSetEntryNode<Object> e: nationalityEntries) {
            builder.withChild(e);
        }
        return builder.build();
    }

    public static YangInstanceIdentifier newPersonPath(String name) {
        return YangInstanceIdentifier.builder(PERSON_LIST_PATH)
                        .nodeWithKey(PERSON_QNAME, PERSON_NAME_QNAME, name).build();
    }
}
