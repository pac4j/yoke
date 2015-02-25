package jsonschema

import com.jetdrone.vertx.yoke.json.JsonSchema
import org.junit.Test

import static org.junit.Assert.assertTrue

class JsonSchemaOrgComplexTest {

    @Test
    public void testFileSystemComplex() {
        def fstab = [
                "/"       : [
                        "storage" : [
                                "type"  : "disk",
                                "device": "/dev/sda1"
                        ],
                        "fstype"  : "btrfs",
                        "readonly": true
                ],
                "/var"    : [
                        "storage": [
                                "type" : "disk",
                                "label": "8f3ba6f4-5c70-46ec-83af-0d5434953e5f"
                        ],
                        "fstype" : "ext4",
                        "options": ["nosuid"]
                ],
                "/tmp"    : [
                        "storage": [
                                "type"    : "tmpfs",
                                "sizeInMB": 64
                        ]
                ],
                "/var/www": [
                        "storage": [
                                "type"      : "nfs",
                                "server"    : "my.nfs.server",
                                "remotePath": "/exports/mypath"
                        ]
                ]
        ]

        assertTrue(JsonSchema.conformsSchema(fstab, "classpath:///jsonschema/fstab.json#"));
    }
}