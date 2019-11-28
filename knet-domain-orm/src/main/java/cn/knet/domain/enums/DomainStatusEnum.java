package cn.knet.domain.enums;

import java.util.LinkedHashMap;
import java.util.Map;
public enum DomainStatusEnum {
    ok("ok","正常状态","域名处于正常状态"),
    inactive("inactive","异常","此状态表明域名没有指定nameserver，无法使用。"),
    serverHold("serverHold","注册局禁止域名解析。","通常因为域名未实名或者是域名滥用被注册局锁定。"),
    addPeriod("addPeriod","新注赎回期","域名注册成功后，出现此状态。如果注册商在此期间删除域名，注册局会将注册费退给注册商。"),
    autoRenewPeriod	("autoRenewPeriod","自动续费赎回期",
            "域名名到期并自动续费成功后，出现此状态。如果注册商在此期间删除域名，注册局会将自动续费的费用退给注册商"),
    renewPeriod	("renewPeriod","续费赎回期",
            "注册商主动续费域名后，出现此状态。如果注册商在这段宽限期内删除域名，那么注册局会将续费的费用退还给注册商。"),
    transferPeriod	("transferPeriod","转移赎回期",
            "域名成功从一个注册商转移到另一个注册商后出现此状态。如果新注册商在此期间删除域名，注册局会将转移费用退给此注册商。"),
    redemptionPeriod	("redemptionPeriod","高价赎回期",
            "此状态表明注册商已经删掉域名。30天内域名会一直保持这个状态，此状态下可以高价赎回域名。"),
    pendingRestore	("pendingRestore","等待赎回报告","此状态表明注册商已经向注册局申请赎回处于redemptionPeriod状态的域名。注册局在等待注册商提交赎回报告时会将域名保持在这个状态。"
            +"如果注册商不能在规定的时间内向注册局系统提交赎回报告以确认赎回操作的话，域名就会恢复为redemptionPeriod状态。"),
    pendingCreate	("pendingCreate","注册中","此状态表明一个域名创建申请已经被epp server接收，并且正在处理。如果此TLD正处于一个特殊注册期（比方日升期），这个状态就表明域名正等待日升期结束后进行域名分配（域名判定）。Open期一般是需要上传资料，等待注册局进行资料审核。"),
    pendingDelete	("pendingDelete","待删除","此状态与redemptionPeriod或者是pendingRestore结合，表面域名处于高价赎回期。如果只有这个状态，表面域名进入待删除期（通常为5天），5天后，域名会掉线，可以被重新注册。"),
    pendingRenew	("pendingRenew","续费中","此状态表明一个域名续费申请已经被epp server接收，并且正在处理中。"),
    pendingTransfer	("pendingTransfer","转移中","此状态表明一个域名转移请求已经被epp server接收，并且正在处理中。域名转移成功后，会移除这个状态。"),
    pendingUpdate	("pendingUpdate","更新中","此状态表明一个域名更新请求已经被epp server接收，并且正在处理中。"),
    serverDeleteProhibited	("serverDeleteProhibited","注册局禁止删除","此状态下注册商端和注册局端都不能删除域名。"),
    serverRenewProhibited	("serverRenewProhibited","注册局禁止续费","此状态下注册商端和注册局端均不能对域名进行续费操作，即域名不能被注册商主动续费，也不能被注册局自动续费。"),
    serverTransferProhibited	("serverTransferProhibited","注册局禁止转移","此状态下注册商端和注册局端均不能对域名进行转移操作。"),
    serverUpdateProhibited	("serverUpdateProhibited","注册局禁止更新","此状态下注册商端和注册局端均不能对域名进行任何更新。"),
    clientDeleteProhibited	("clientDeleteProhibited","注册商禁止删除","此状态下注册商不能删除域名。如果要删除域名，需注册商自己通过domain-update命令移除这个状态。"),
    clientHold	("clientHold","注册商禁止解析","注册商禁止域名解析。如果要解析域名，需注册商自己通过domain-update命令移除这个状态。"),
    clientRenewProhibited	("clientRenewProhibited","注册商禁止续费","此状态下注册商不能对域名进行续费操作。如果要续费域名，需注册商自己通过domain-update命令移除这个状态。"),
    clientTransferProhibited	("clientTransferProhibited","注册商禁止转移","此状态下注册商不能对域名发起转移申请。如果要转移域名，需注册商自己通过domain-update命令移除这个状态。"),
    clientUpdateProhibited	("clientUpdateProhibited","注册商禁止更新","此状态下注册商不能对域名进行更新。如果要更新域名，需注册商自己通过domain-update命令移除这个状态。");

    private static final Map<String, String> MAPPING = new LinkedHashMap<String, String>();

    private static final Map<String, String> INVERSE_MAPPING = new LinkedHashMap<String, String>();
    private String value;
    private String text;
    private String detail;


    DomainStatusEnum(final String value, final String text,String detail) {
        this.value = value;
        this.text = text;
        this.detail = detail;

    }

    static {
        for (DomainStatusEnum em : DomainStatusEnum.values()) {
            MAPPING.put(em.getText(), em.getValue());
            INVERSE_MAPPING.put(em.getValue(), em.getText());
        }
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
    public String getDetail() {
        return detail;
    }

    /**
     *
     * @return
     */
    public static Map<String, String> mapping() {
        return MAPPING;
    }

    /**
     *
     * @return
     */
    public static Map<String, String> inverseMapping() {
        return INVERSE_MAPPING;
    }

    public static DomainStatusEnum get(String enumValue) {
        for (DomainStatusEnum em : DomainStatusEnum.values()) {
            if (em.getValue().equals(enumValue)) {
                return em;
            }
        }
        throw new IllegalArgumentException("Can't get enum with this enumValue.");
    }

}