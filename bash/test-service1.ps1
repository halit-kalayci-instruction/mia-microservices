
for ($i = 1; $i -le 10; $i++) {
    $response = & curl.exe -s --header "Connection: close" http://127.0.0.1:57374/api/base
    if ($response -match "Pod: (.+?), IP: (.+?) - Received message from other service:(.+)") {
        $podName = $matches[1]
        $ip = $matches[2]
        $message = $matches[3]
        Write-Output "Istek $i, Yonlendirildigi IP: $ip , Pod Name: $podName, Servis 2: $message"
    } else {
        Write-Output "Istek $i, Yanıt alınamadı"
    }
}
