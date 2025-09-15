# Common
-keepattributes Signature,InnerClasses,EnclosingMethod,RuntimeVisibleAnnotations,*Annotation*

# Gson
-keepclassmembers,allowobfuscation class * {
 @com.google.gson.annotations.SerializedName <fields>;
}

# OkHttp
-dontwarn javax.annotation.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-dontwarn org.codehaus.mojo.animal_sniffer.*
-dontwarn okhttp3.internal.platform.ConscryptPlatform

# Pointhome
-keeppackagenames com.avatye.pointhome.**
-keep class com.avatye.pointhome.** { *; }

# Adcash
-keep class com.avatye.adcash.** { *; }

# IGAWorks
-keep class com.igaworks.ssp.** { *; }
-keep class com.igaworks.ssp.R$* # R 클래스와 그 멤버들을 난독화에서 제외
-dontwarn com.igaworks.ssp.** # IGAWorks 관련 경고 메시지 무시
-keepclassmembers class com.igaworks.ssp.R$*{ # R 클래스 내의 정적 필드를 난독화에서 제외
  public static <fields>;
}

# Unity Ads
-keep class com.unity3d.ads.** { *; }
-keep class com.unity3d.services.** { *; }

# Vungle
-dontwarn com.vungle.warren.downloader.DownloadRequestMediator$Status
-dontwarn com.vungle.warren.error.VungleError$ErrorCode
-dontwarn com.google.android.gms.common.GoogleApiAvailabilityLight
-dontwarn com.google.android.gms.ads.identifier.AdvertisingIdClient
-dontwarn com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
-keep class com.moat.** { *; } # MOAT 광고 추적 라이브러리를 난독화에서 제외
-dontwarn com.moat.** # MOAT 관련 경고 메시지 무시

# Pangle
-keep class com.bytedance.sdk.** { *; }
-keep class com.pgl.sys.ces.* { *; }

# Facebook Audience Network(FAN)
-keep class com.facebook.ads.** { *; }

# Cauly
-keep class com.fsn.cauly.** {
	  public *; protected *;
}
-keep class com.trid.tridad.** {
 	 public *; protected *;
}

#mezzomedia
-keep class com.mmc.man.** { *; }
-keep interface com.mmc.man.** { *; }

# Mobwith
-dontwarn com.mobwith.adapters.**
-keep public class com.mobwith.** { *; }
-keepnames class com.httpmodule.internal.publicsuffix.PublicSuffixDatabase
-keep public class com.httpmodule.** { public *;}