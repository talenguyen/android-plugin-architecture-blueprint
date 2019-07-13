set -e
stop="./gradlew --stop"
build="./gradlew assembleDebug --stacktrace"
install="adb install-multiple \
/Users/lap00984/Documents/hometest/PluginArchitecture/app/build/outputs/apk/debug/app-debug.apk \
/Users/lap00984/Documents/hometest/PluginArchitecture/data/build/outputs/apk/debug/data-debug.apk \
/Users/lap00984/Documents/hometest/PluginArchitecture/ui/build/outputs/apk/debug/ui-debug.apk \
/Users/lap00984/Documents/hometest/PluginArchitecture/detail/build/outputs/apk/debug/detail-debug.apk \
/Users/lap00984/Documents/hometest/PluginArchitecture/listing/build/outputs/apk/debug/listing-debug.apk"

uninstall="adb uninstall com.example.pluginarchitecture"
launch="adb shell am start -n 'com.example.pluginarchitecture/com.example.pluginarchitecture.ui.MainActivity' -a android.intent.action.MAIN -c android.intent.category.LAUNCHER"

$build && $uninstall || true && $install && $launch

echo "Total time: $SECONDS secs"

now=$(date)