/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.inventory.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.inventory.model.CommerceInventoryAudit;
import com.liferay.commerce.inventory.model.CommerceInventoryAuditModel;
import com.liferay.commerce.inventory.model.CommerceInventoryAuditSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommerceInventoryAudit service. Represents a row in the &quot;CIAudit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommerceInventoryAuditModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceInventoryAuditImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceInventoryAuditImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceInventoryAuditModelImpl
	extends BaseModelImpl<CommerceInventoryAudit>
	implements CommerceInventoryAuditModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce inventory audit model instance should use the <code>CommerceInventoryAudit</code> interface instead.
	 */
	public static final String TABLE_NAME = "CIAudit";

	public static final Object[][] TABLE_COLUMNS = {
		{"CIAuditId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"sku", Types.VARCHAR}, {"description", Types.CLOB},
		{"quantity", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CIAuditId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("sku", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CIAudit (CIAuditId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,sku VARCHAR(75) null,description TEXT null,quantity INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table CIAudit";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceInventoryAudit.commerceInventoryAuditId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY CIAudit.CIAuditId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.inventory.model.CommerceInventoryAudit"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.inventory.model.CommerceInventoryAudit"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.inventory.model.CommerceInventoryAudit"),
		true);

	public static final long CREATEDATE_COLUMN_BITMASK = 1L;

	public static final long SKU_COLUMN_BITMASK = 2L;

	public static final long COMMERCEINVENTORYAUDITID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceInventoryAudit toModel(
		CommerceInventoryAuditSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceInventoryAudit model = new CommerceInventoryAuditImpl();

		model.setCommerceInventoryAuditId(
			soapModel.getCommerceInventoryAuditId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setSku(soapModel.getSku());
		model.setDescription(soapModel.getDescription());
		model.setQuantity(soapModel.getQuantity());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceInventoryAudit> toModels(
		CommerceInventoryAuditSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceInventoryAudit> models =
			new ArrayList<CommerceInventoryAudit>(soapModels.length);

		for (CommerceInventoryAuditSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.inventory.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.inventory.model.CommerceInventoryAudit"));

	public CommerceInventoryAuditModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceInventoryAuditId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceInventoryAuditId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceInventoryAuditId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceInventoryAudit.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceInventoryAudit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceInventoryAudit, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceInventoryAudit, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryAudit, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceInventoryAudit)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceInventoryAudit, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceInventoryAudit, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceInventoryAudit)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceInventoryAudit, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceInventoryAudit, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceInventoryAudit>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceInventoryAudit.class.getClassLoader(),
			CommerceInventoryAudit.class, ModelWrapper.class);

		try {
			Constructor<CommerceInventoryAudit> constructor =
				(Constructor<CommerceInventoryAudit>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CommerceInventoryAudit, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceInventoryAudit, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceInventoryAudit, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceInventoryAudit, Object>>();
		Map<String, BiConsumer<CommerceInventoryAudit, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceInventoryAudit, ?>>();

		attributeGetterFunctions.put(
			"commerceInventoryAuditId",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getCommerceInventoryAuditId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceInventoryAuditId",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object commerceInventoryAuditId) {

					commerceInventoryAudit.setCommerceInventoryAuditId(
						(Long)commerceInventoryAuditId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object companyId) {

					commerceInventoryAudit.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object userId) {

					commerceInventoryAudit.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object userName) {

					commerceInventoryAudit.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object createDate) {

					commerceInventoryAudit.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object modifiedDate) {

					commerceInventoryAudit.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"sku",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getSku();
				}

			});
		attributeSetterBiConsumers.put(
			"sku",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit, Object sku) {

					commerceInventoryAudit.setSku((String)sku);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object description) {

					commerceInventoryAudit.setDescription((String)description);
				}

			});
		attributeGetterFunctions.put(
			"quantity",
			new Function<CommerceInventoryAudit, Object>() {

				@Override
				public Object apply(
					CommerceInventoryAudit commerceInventoryAudit) {

					return commerceInventoryAudit.getQuantity();
				}

			});
		attributeSetterBiConsumers.put(
			"quantity",
			new BiConsumer<CommerceInventoryAudit, Object>() {

				@Override
				public void accept(
					CommerceInventoryAudit commerceInventoryAudit,
					Object quantity) {

					commerceInventoryAudit.setQuantity((Integer)quantity);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceInventoryAuditId() {
		return _commerceInventoryAuditId;
	}

	@Override
	public void setCommerceInventoryAuditId(long commerceInventoryAuditId) {
		_commerceInventoryAuditId = commerceInventoryAuditId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask |= CREATEDATE_COLUMN_BITMASK;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getSku() {
		if (_sku == null) {
			return "";
		}
		else {
			return _sku;
		}
	}

	@Override
	public void setSku(String sku) {
		_columnBitmask |= SKU_COLUMN_BITMASK;

		if (_originalSku == null) {
			_originalSku = _sku;
		}

		_sku = sku;
	}

	public String getOriginalSku() {
		return GetterUtil.getString(_originalSku);
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceInventoryAudit.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceInventoryAudit toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceInventoryAudit>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceInventoryAuditImpl commerceInventoryAuditImpl =
			new CommerceInventoryAuditImpl();

		commerceInventoryAuditImpl.setCommerceInventoryAuditId(
			getCommerceInventoryAuditId());
		commerceInventoryAuditImpl.setCompanyId(getCompanyId());
		commerceInventoryAuditImpl.setUserId(getUserId());
		commerceInventoryAuditImpl.setUserName(getUserName());
		commerceInventoryAuditImpl.setCreateDate(getCreateDate());
		commerceInventoryAuditImpl.setModifiedDate(getModifiedDate());
		commerceInventoryAuditImpl.setSku(getSku());
		commerceInventoryAuditImpl.setDescription(getDescription());
		commerceInventoryAuditImpl.setQuantity(getQuantity());

		commerceInventoryAuditImpl.resetOriginalValues();

		return commerceInventoryAuditImpl;
	}

	@Override
	public int compareTo(CommerceInventoryAudit commerceInventoryAudit) {
		long primaryKey = commerceInventoryAudit.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceInventoryAudit)) {
			return false;
		}

		CommerceInventoryAudit commerceInventoryAudit =
			(CommerceInventoryAudit)obj;

		long primaryKey = commerceInventoryAudit.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceInventoryAuditModelImpl commerceInventoryAuditModelImpl = this;

		commerceInventoryAuditModelImpl._originalCreateDate =
			commerceInventoryAuditModelImpl._createDate;

		commerceInventoryAuditModelImpl._setModifiedDate = false;

		commerceInventoryAuditModelImpl._originalSku =
			commerceInventoryAuditModelImpl._sku;

		commerceInventoryAuditModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceInventoryAudit> toCacheModel() {
		CommerceInventoryAuditCacheModel commerceInventoryAuditCacheModel =
			new CommerceInventoryAuditCacheModel();

		commerceInventoryAuditCacheModel.commerceInventoryAuditId =
			getCommerceInventoryAuditId();

		commerceInventoryAuditCacheModel.companyId = getCompanyId();

		commerceInventoryAuditCacheModel.userId = getUserId();

		commerceInventoryAuditCacheModel.userName = getUserName();

		String userName = commerceInventoryAuditCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceInventoryAuditCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceInventoryAuditCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceInventoryAuditCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceInventoryAuditCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceInventoryAuditCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceInventoryAuditCacheModel.sku = getSku();

		String sku = commerceInventoryAuditCacheModel.sku;

		if ((sku != null) && (sku.length() == 0)) {
			commerceInventoryAuditCacheModel.sku = null;
		}

		commerceInventoryAuditCacheModel.description = getDescription();

		String description = commerceInventoryAuditCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			commerceInventoryAuditCacheModel.description = null;
		}

		commerceInventoryAuditCacheModel.quantity = getQuantity();

		return commerceInventoryAuditCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceInventoryAudit, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceInventoryAudit, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryAudit, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceInventoryAudit)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CommerceInventoryAudit, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceInventoryAudit, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceInventoryAudit, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceInventoryAudit)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceInventoryAudit>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _commerceInventoryAuditId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _originalCreateDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _sku;
	private String _originalSku;
	private String _description;
	private int _quantity;
	private long _columnBitmask;
	private CommerceInventoryAudit _escapedModel;

}